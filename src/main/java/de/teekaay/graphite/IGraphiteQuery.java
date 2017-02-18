package de.teekaay.graphite;

public interface IGraphiteQuery {
    /**
     * Render to the query part of the Graphite API URL.
     *
     * @return The query part of the URL
     */
    String render();
}
