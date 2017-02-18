package de.teekaay.graphite;

import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

public interface IGraphiteResponseEncoder {
    /**
     * Encode the raw String to a {@link GraphiteTimeSeries}.
     *
     * @param s The raw String (e.g. CSV or JSON)
     * @return The time series object
     */
    GraphiteTimeSeries encode(String s);
}
