package de.teekaay.graphite;

import de.teekaay.graphite.consumer.LocalResourceConsumer;
import de.teekaay.graphite.timeseries.CsvTimeSeriesEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

public class CLI {
    public static void main(String[] args) {
        System.out.println(parseCsvResource());
    }

    public static GraphiteTimeSeries parseCsvResource() {
        String csvData = "classpath://data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalResourceConsumer resourceConsumer = new LocalResourceConsumer(encoder);
        GraphiteTimeSeries timeSeries = resourceConsumer.get(csvData);
        return timeSeries;
    }
}
