package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LocalResourceConsumer extends AbstractConsumer implements IGraphiteConsumer {
    private static final String CLASSPATH_SCHEMA = "classpath://";

    public LocalResourceConsumer(final IGraphiteResponseEncoder encoder) {
        super(encoder);
    }

    @Override
    public GraphiteTimeSeries get(final String path) throws GraphiteConsumptionException {
        String realPath = path.replace(CLASSPATH_SCHEMA, "");
        File file = getFileFromResources(realPath);
        return getEncoder().encode(parseFile(file));
    }

    @Override
    public boolean supports(final String schema) {
        return schema.equals(CLASSPATH_SCHEMA);
    }

    private File getFileFromResources(final String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(path).getFile());
    }

    private String parseFile(final File file) throws GraphiteConsumptionException {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            throw new GraphiteConsumptionException(String.format("Could not parse file %s: %s", file.getAbsolutePath(), e.getLocalizedMessage()));
        }
        return result.toString();
    }
}
