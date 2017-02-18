package de.teekaay.graphite.timeseries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CsvTimeSeriesEncoderTest {
    @Test
    public void itEncodesACsvString() throws Exception {
        // given
        String content = "entries,2011-07-28 01:53:00,1.0\n" +
                         "entries,2011-07-28 01:54:00,2.0";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        // when
        GraphiteTimeSeries timeSeries = encoder.encode(content);
        // then
        assertEquals(2, timeSeries.getEntries().size());
        assertEquals("entries", timeSeries.getEntries().get(0).getTarget());
        assertEquals("entries", timeSeries.getEntries().get(1).getTarget());
        assertEquals(1311817980, (long)timeSeries.getEntries().get(0).getTimestamp()); // need to cast to long because of ambigious method call
        assertEquals(1311818040, (long)timeSeries.getEntries().get(1).getTimestamp()); // same here
        assertEquals(1.0, (double)timeSeries.getEntries().get(0).getValue(), 0.001);
        assertEquals(2.0, (double)timeSeries.getEntries().get(1).getValue(), 0.001);
    }
}
