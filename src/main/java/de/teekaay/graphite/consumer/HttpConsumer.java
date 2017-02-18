package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.IGraphiteResponseEncoder;
import de.teekaay.graphite.timeseries.GraphiteTimeSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConsumer extends AbstractConsumer implements IGraphiteConsumer {
    private static final String HTTP_SCHEMA = "http";
    private static final String HTTPS_SCHEMA = "https";
    private static final String HTTP_METHOD = "GET";

    public HttpConsumer(final IGraphiteResponseEncoder encoder) {
        super(encoder);
    }

    @Override
    public GraphiteTimeSeries get(final String path) throws GraphiteConsumptionException {
        try {
            URL url = new URL(path);
            try{
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod(HTTP_METHOD);
                return getEncoder().encode(readFromConnection(con));
            } catch (IOException e) {
                e.printStackTrace();
                throw new GraphiteConsumptionException(String.format("Could not read from HTTP connection: %s", e.getLocalizedMessage()));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new GraphiteConsumptionException(String.format("Could not parse %s: %s", path, e.getLocalizedMessage()));
        }
    }

    @Override
    public boolean supports(final String schema) {
        return schema.equals(HTTP_SCHEMA) || schema.equals(HTTPS_SCHEMA);
    }

    private String readFromConnection(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
