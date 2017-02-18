package de.teekaay.graphite;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemplatedGraphiteQueryTest {
    @Test
    public void itSubstitutesPlaceholders() throws Exception {
        // given
        String template = "target=${target}&format=${format}";
        Map<String, String> variables = new HashMap<>();
        variables.put("format", "csv");
        variables.put("target", "mytarget");
        TemplatedGraphiteQuery templatedGraphiteQuery = new TemplatedGraphiteQuery(template, variables);
        // when
        String rendered = templatedGraphiteQuery.render();
        // then
        assertEquals("target=mytarget&format=csv", rendered);
    }

    @Test
    public void itAddsVariables() {
        // given
        TemplatedGraphiteQuery templatedGraphiteQuery = new TemplatedGraphiteQuery();
        templatedGraphiteQuery.addVariable("from", "-1d");
        templatedGraphiteQuery.addVariable("until", "now");
        // when
        String rendered = templatedGraphiteQuery.render();
        // then
        assertTrue(rendered.contains("from=-1d"));
        assertTrue(rendered.contains("until=now"));
    }
}
