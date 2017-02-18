package de.teekaay.graphite.timeseries;

import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.util.GraphiteTime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTimeSeriesEncoder implements IGraphiteResponseEncoder {
    private static final int COLUMN_COUNT = 3;

    @Override
    public GraphiteTimeSeries encode(final String s) {
        List<String> lines = Arrays.asList(s.split("\n"));
        List<TimeSeriesEntry> entries = lines.stream()
                .map(line -> encodeLine(line))
                .filter(tse -> tse != null)
                .collect(Collectors.toList());
        return new GraphiteTimeSeries(entries);
    }

    private TimeSeriesEntry encodeLine(String line) {
        String[] columns = line.split(",");
        if(isCompleteLine(columns)) {
            String target = columns[0];
            Long timestamp = GraphiteTime.convertFromGraphiteDate(columns[1]);
            Double value = Double.parseDouble(columns[2]);
            return new TimeSeriesEntry(target, timestamp, value);
        }
        return null;
    }

    public boolean isCompleteLine(String[] line) {
        if(line.length != COLUMN_COUNT) {
            return false;
        }
        return line[0] != "" && line[1] != "" && line[2] != "";
    }
}
