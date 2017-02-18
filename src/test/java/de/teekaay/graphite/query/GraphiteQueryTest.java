package de.teekaay.graphite.query;

import de.teekaay.graphite.query.GraphiteQuery;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphiteQueryTest {
    @Test
    public void itReturnsTheRightUrl() throws Exception {
        // given
        GraphiteQuery query = new GraphiteQuery("target", "-1d", "now", "csv");
        // when
        String rendered = query.render();
        // then
        assertEquals("from=-1d&until=now&target=target&format=csv", rendered);
    }
}
