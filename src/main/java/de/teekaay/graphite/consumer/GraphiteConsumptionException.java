package de.teekaay.graphite.consumer;

import java.io.IOException;

public class GraphiteConsumptionException extends IOException {
    public GraphiteConsumptionException(final String message) {
        super(message);
    }
}
