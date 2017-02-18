package de.teekaay.graphite;

public class GraphiteQuery {
    private static final String TEMPLATE = "from=%s&until=%s&target=%s&format=%s";
    private String target;
    private String from;
    private String until;
    private String format;

    public GraphiteQuery(final String target, final String from, final String until, final String format) {
        this.target = target;
        this.from = from;
        this.until = until;
        this.format = format;
    }

    public GraphiteQuery() {
        this("", "", "", "");
    }

    public String render() {
        return String.format(TEMPLATE, from, until, target, format);
    }

    public String getTarget() {
        return target;
    }

    public GraphiteQuery setTarget(final String target) {
        this.target = target;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public GraphiteQuery setFrom(final String from) {
        this.from = from;
        return this;
    }

    public String getUntil() {
        return until;
    }

    public GraphiteQuery setUntil(final String until) {
        this.until = until;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public GraphiteQuery setFormat(final String format) {
        this.format = format;
        return this;
    }

    @Override
    public String toString() {
        return "GraphiteQuery{" +
                "target='" + target + '\'' +
                ", from='" + from + '\'' +
                ", until='" + until + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
