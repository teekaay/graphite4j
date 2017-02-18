package de.teekaay.graphite.util;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class GraphiteTimeTest {
    @Test
    public void itConvertsToHHMM_YYMMDD() throws Exception {
        // given
        String expected = "1000_20161010";
        LocalDateTime dateTime = LocalDateTime.of(2016, 10, 10, 10, 0);
        // when
        String converted = GraphiteTime.convertToHMYMD(dateTime);
        // then
        assertEquals(expected, converted);
    }

    @Test
    public void itReturnsMinus1h() throws Exception {
        // given
        int hours = 1;
        String expected = "-1h";
        // when
        String ago = GraphiteTime.timeAgo(hours, "h");
        // then
        assertEquals(expected, ago);
    }
}
