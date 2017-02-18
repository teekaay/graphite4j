package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalFileConsumer implements IGraphiteConsumer {
    private static final String FILE_SCHEMA = "file://";
    private IGraphiteResponseEncoder encoder;

    public LocalFileConsumer(final IGraphiteResponseEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public GraphiteTimeSeries get(final String path) throws IOException {
        //String realPath = path.replace(FILE_SCHEMA, "");
        String realPath = path;
        try (Stream<String> stream = Files.lines(Paths.get(realPath))) {
            String result = stream.collect(Collectors.joining("\n"));
            return encoder.encode(result);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean supports(final String schema) {
        return schema.equals(FILE_SCHEMA);
    }
}
