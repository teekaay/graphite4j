package de.teekaay.graphite;

import de.teekaay.graphite.consumer.GraphiteConsumptionException;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

public interface IGraphiteConsumer {
    /**
     * Get the dataset from some resource, e.g. network via HTTP or
     * from the file system and parse it into a {@link GraphiteTimeSeries}.
     *
     * @param path The path to the resource
     * @return The time series
     */
    GraphiteTimeSeries get(String path) throws GraphiteConsumptionException;

    /**
     * Returns true if the resource is supported, otherwise false.
     *
     * @param schema The schema
     * @return
     */
    boolean supports(String schema);
}
