package de.teekaay.graphite;

public class GraphiteClientConfig {
    private String host;

    public String getHost() {
        return host;
    }

    public GraphiteClientConfig setHost(final String host) {
        this.host = host;
        return this;
    }
}
