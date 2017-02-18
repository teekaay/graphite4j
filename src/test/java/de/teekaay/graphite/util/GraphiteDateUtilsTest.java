package de.teekaay.graphite.util;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class GraphiteDateUtilsTest {
    @Test
    public void itConvertsToHHMM_YYMMDD() throws Exception {
        // given
        String expected = "1000_20161010";
        LocalDateTime dateTime = LocalDateTime.of(2016, 10, 10, 10, 0);
        // when
        String converted = GraphiteDateUtils.convertToHMYMD(dateTime);
        // then
        assertEquals(expected, converted);
    }
}
