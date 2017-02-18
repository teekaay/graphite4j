package de.teekaay.graphite.consumer;

import de.teekaay.graphite.IGraphiteConsumer;
import de.teekaay.graphite.IGraphiteResponseEncoder;

import java.net.URI;
import java.net.URISyntaxException;

public class GraphiteConsumerFactory {
    public static final String HTTP_SCHEMA = "http";
    public static final String HTTPS_SCHEMA = "https";
    public static final String CLASSPATH_SCHEMA = "classpath";
    public static final String FILE_SCHEMA = "file";

    public static HttpConsumer httpConsumer(IGraphiteResponseEncoder encoder) {
        return new HttpConsumer(encoder);
    }

    public static LocalFileConsumer localFileConsumer(IGraphiteResponseEncoder encoder) {
        return new LocalFileConsumer(encoder);
    }

    public static LocalResourceConsumer localResourceConsumer(IGraphiteResponseEncoder encoder) {
        return new LocalResourceConsumer(encoder);
    }

    public static IGraphiteConsumer createConsumer(String resource, IGraphiteResponseEncoder encoder) {
        String scheme = parseScheme(resource);
        switch(scheme) {
            case HTTP_SCHEMA:
                return httpConsumer(encoder);
            case HTTPS_SCHEMA:
                return httpConsumer(encoder);
            case CLASSPATH_SCHEMA:
                return localResourceConsumer(encoder);
            case FILE_SCHEMA:
                return localFileConsumer(encoder);
            default:
                throw new IllegalArgumentException("Could not find a consumer for scheme " + scheme);
        }
    }

    public static String asScheme(String resource, String schema) {
        if(hasScheme(resource)) {
            return resource;
        }
        return schema + "://" + resource;
    }

    public static boolean hasScheme(String resource) {
        String scheme = parseScheme(resource);
        if(scheme == null) {
            return false;
        }
        return true;
    }

    public static String parseScheme(String resource) {
        try {
            URI uri = new URI(resource);
            return uri.getScheme();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Could not parse scheme of " + resource);
        }
    }
}
