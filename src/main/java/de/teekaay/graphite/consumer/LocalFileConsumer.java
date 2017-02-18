package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalFileConsumer extends AbstractConsumer implements IGraphiteConsumer {
    private static final String FILE_SCHEMA = "file://";

    public LocalFileConsumer(final IGraphiteResponseEncoder encoder) {
        super(encoder);
    }

    @Override
    public GraphiteTimeSeries get(final String path) throws GraphiteConsumptionException {
        String realPath = path;
        try (Stream<String> stream = Files.lines(Paths.get(realPath))) {
            String result = stream.collect(Collectors.joining("\n"));
            return getEncoder().encode(result);
        } catch (IOException e) {
            throw new GraphiteConsumptionException(String.format("Could not find or parse %s: %s", path, e.getLocalizedMessage()));
        }
    }

    @Override
    public boolean supports(final String schema) {
        return schema.equals(FILE_SCHEMA);
    }
}
