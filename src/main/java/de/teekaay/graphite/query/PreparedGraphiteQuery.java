package de.teekaay.graphite.query;

import de.teekaay.graphite.IGraphiteQuery;

public class PreparedGraphiteQuery implements IGraphiteQuery {
    private String query;

    public PreparedGraphiteQuery(String query) {
        this.query = query;
    }

    public String render() {
        return query;
    }

    public String getQuery() {
        return query;
    }

    public PreparedGraphiteQuery setQuery(final String query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return "PreparedGraphiteQuery{" +
                "query='" + query + '\'' +
                '}';
    }
}
