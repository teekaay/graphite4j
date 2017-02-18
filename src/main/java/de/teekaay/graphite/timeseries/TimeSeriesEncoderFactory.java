package de.teekaay.graphite.timeseries;

import de.teekaay.graphite.IGraphiteResponseEncoder;

public class TimeSeriesEncoderFactory {
    public static CsvTimeSeriesEncoder csvTimeSeriesEncoder() {
        return new CsvTimeSeriesEncoder();
    }

    public static IGraphiteResponseEncoder createEncoder(String resource) {
        return csvTimeSeriesEncoder();
    }
}
