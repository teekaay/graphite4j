package de.teekaay.graphite.timeseries;

import java.util.ArrayList;
import java.util.List;

public class GraphiteTimeSeries {
    private List<TimeSeriesEntry> entries;

    public GraphiteTimeSeries() {
        this.entries = new ArrayList<>();
    }

    public GraphiteTimeSeries(final List<TimeSeriesEntry> entries) {
        this.entries = entries;
    }

    public List<TimeSeriesEntry> getEntries() {
        return entries;
    }

    public GraphiteTimeSeries setEntries(final List<TimeSeriesEntry> entries) {
        this.entries = entries;
        return this;
    }

    @Override
    public String toString() {
        return "GraphiteTimeSeries{" +
                "entries=" + entries +
                '}';
    }
}
