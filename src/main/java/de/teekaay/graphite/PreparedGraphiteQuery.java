package de.teekaay.graphite;

public class PreparedGraphiteQuery {
    private String query;

    public PreparedGraphiteQuery(String query) {
        this.query = query;
    }

    public String render() {
        return query;
    }
}
