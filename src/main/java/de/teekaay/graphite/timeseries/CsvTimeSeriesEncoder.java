package de.teekaay.graphite.timeseries;

import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.util.GraphiteTime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTimeSeriesEncoder implements IGraphiteResponseEncoder {
    @Override
    public GraphiteTimeSeries encode(final String s) {
        List<String> lines = Arrays.asList(s.split("\n"));
        List<TimeSeriesEntry> entries = lines.stream().map(line -> encodeLine(line)).collect(Collectors.toList());
        return new GraphiteTimeSeries(entries);
    }

    private TimeSeriesEntry encodeLine(String line) {
        String[] columns = line.split(",");
        String target = columns[0];
        Long timestamp = GraphiteTime.convertFromGraphiteDate(columns[1]);
        Double value = Double.parseDouble(columns[2]);
        return new TimeSeriesEntry(target, timestamp, value);
    }
}
