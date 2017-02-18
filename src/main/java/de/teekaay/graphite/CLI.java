package de.teekaay.graphite;

import de.teekaay.graphite.consumer.GraphiteConsumptionException;
import de.teekaay.graphite.consumer.LocalFileConsumer;
import de.teekaay.graphite.consumer.LocalResourceConsumer;
import de.teekaay.graphite.query.PreparedGraphiteQuery;
import de.teekaay.graphite.timeseries.CsvTimeSeriesEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.nio.file.Paths;

public class CLI {
    public static void main(String[] args) throws GraphiteConsumptionException {
        System.out.println(parseCsvResource());
        System.out.println(parseCsvFile());
        System.out.println(getWithClient());
    }

    public static GraphiteTimeSeries getWithClient() throws GraphiteConsumptionException {
        String csvData = "classpath://data.csv";
        return new GraphiteClient().getData(new PreparedGraphiteQuery(csvData));
    }

    public static GraphiteTimeSeries parseCsvResource() throws GraphiteConsumptionException {
        String csvData = "classpath://data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalResourceConsumer resourceConsumer = new LocalResourceConsumer(encoder);
        GraphiteTimeSeries timeSeries = resourceConsumer.get(csvData);
        return timeSeries;
    }

    public static GraphiteTimeSeries parseCsvFile() throws GraphiteConsumptionException {
        String csvData = Paths.get(".").toAbsolutePath().normalize().toString() + "/data/data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalFileConsumer fileConsumer = new LocalFileConsumer(encoder);
        GraphiteTimeSeries timeSeries = fileConsumer.get(csvData);
        return timeSeries;
    }
}
