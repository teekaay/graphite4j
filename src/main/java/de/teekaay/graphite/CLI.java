package de.teekaay.graphite;

import de.teekaay.graphite.consumer.LocalFileConsumer;
import de.teekaay.graphite.consumer.LocalResourceConsumer;
import de.teekaay.graphite.timeseries.CsvTimeSeriesEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.io.IOException;
import java.nio.file.Paths;

public class CLI {
    public static void main(String[] args) {
        System.out.println(parseCsvResource());
        System.out.println(parseCsvFile());
    }

    public static GraphiteTimeSeries parseCsvResource() {
        String csvData = "classpath://data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalResourceConsumer resourceConsumer = new LocalResourceConsumer(encoder);
        GraphiteTimeSeries timeSeries = resourceConsumer.get(csvData);
        return timeSeries;
    }

    public static GraphiteTimeSeries parseCsvFile() {
        String csvData = Paths.get(".").toAbsolutePath().normalize().toString() + "/data/data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalFileConsumer fileConsumer = new LocalFileConsumer(encoder);
        GraphiteTimeSeries timeSeries = null;
        try {
            timeSeries = fileConsumer.get(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timeSeries;
    }
}
