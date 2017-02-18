package de.teekaay.graphite;

import de.teekaay.graphite.consumer.GraphiteConsumerFactory;
import de.teekaay.graphite.consumer.GraphiteConsumptionException;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;
import de.teekaay.graphite.timeseries.TimeSeriesEncoderFactory;

public class GraphiteClient {
    public GraphiteTimeSeries getData(IGraphiteQuery query) throws GraphiteConsumptionException {
        String pathToResource = query.render();
        IGraphiteResponseEncoder encoder = TimeSeriesEncoderFactory.createEncoder(pathToResource);
        IGraphiteConsumer consumer = GraphiteConsumerFactory.createConsumer(pathToResource, encoder);
        return consumer.get(pathToResource);
    }
}
