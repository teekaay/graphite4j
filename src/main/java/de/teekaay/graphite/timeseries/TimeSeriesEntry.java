package de.teekaay.graphite.timeseries;

public class TimeSeriesEntry {
    private String target;
    private Long timestamp;
    private Double value;

    public TimeSeriesEntry(final String target, final Long timestamp, final Double value) {
        this.target = target;
        this.timestamp = timestamp;
        this.value = value;
    }

    public TimeSeriesEntry() {
        this.target = "";
        this.timestamp = 0L;
        this.value = 0.0;
    }

    public String getTarget() {
        return target;
    }

    public TimeSeriesEntry setTarget(final String target) {
        this.target = target;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TimeSeriesEntry setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public TimeSeriesEntry setValue(final Double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "TimeSeriesEntry{" +
                "target='" + target + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
