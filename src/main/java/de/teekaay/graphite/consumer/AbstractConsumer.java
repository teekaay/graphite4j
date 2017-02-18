package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteResponseEncoder;

public abstract class AbstractConsumer {
    private IGraphiteResponseEncoder encoder;

    public AbstractConsumer(final IGraphiteResponseEncoder encoder) {
        this.encoder = encoder;
    }

    public IGraphiteResponseEncoder getEncoder() {
        return encoder;
    }

    public AbstractConsumer setEncoder(final IGraphiteResponseEncoder encoder) {
        this.encoder = encoder;
        return this;
    }
}
