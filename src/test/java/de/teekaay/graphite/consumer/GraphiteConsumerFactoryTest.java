package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.consumer.GraphiteConsumerFactory;
import de.teekaay.graphite.consumer.HttpConsumer;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphiteConsumerFactoryTest {
    @Test
    public void itCreatesHttpConsumer() throws Exception {
        // given
        String resource = "http://graphite/";
        // when
        IGraphiteConsumer consumer = GraphiteConsumerFactory.createConsumer(resource, null);
        // then
        assertEquals(HttpConsumer.class, consumer.getClass());
    }

    @Test
    public void itParsesHttpScheme() throws Exception {
        // given
        String resource = "http://resource.org";
        // when
        String scheme = GraphiteConsumerFactory.parseScheme(resource);
        // then
        assertEquals("http", scheme);
    }

    @Test
    public void itCreatesHttpScheme() {
        // given
        String scheme = "http";
        String resource = "graphite.org";
        // when
        String resourceWithScheme = GraphiteConsumerFactory.asScheme(resource, scheme);
        // then
        assertEquals("http://graphite.org", resourceWithScheme);
    }

    @Test
    public void itOmitsSchemeIfExists() {
        // given
        String resource = "http://graphite.org";
        String scheme = "http";
        // then
        assertEquals(resource, GraphiteConsumerFactory.asScheme(resource, scheme));
    }

    @Test
    public void itDetectsHttpScheme() throws Exception {
        // given
        String resourceWithScheme = "http://graphite.org";
        String resourceWithoutScheme = "graphite.org";
        // then
        assertTrue(GraphiteConsumerFactory.hasScheme(resourceWithScheme));
        assertFalse(GraphiteConsumerFactory.hasScheme(resourceWithoutScheme));
    }
}
