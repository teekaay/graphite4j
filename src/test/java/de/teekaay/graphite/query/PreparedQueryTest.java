package de.teekaay.graphite.query;

import de.teekaay.graphite.query.PreparedGraphiteQuery;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreparedQueryTest {
    @Test
    public void itDoesNotChangeTheInput() {
        // given
        String query = "http://my-server.com/render?target=my-target";
        // when
        PreparedGraphiteQuery preparedGraphiteQuery = new PreparedGraphiteQuery(query);
        // then
        assertEquals(query, preparedGraphiteQuery.render());
    }
}
