# Graphite Client for Java

**WORK IN PROGRESS**

A Java library for talking to Graphite's `render` API
for retrieving raw data (`csv` and `json`) and working with Graphite's dataset
format. 

## Features

* Multiple ways to construct query URLs (prepared, templated, ...)
* Consumers for local files, classpath resources and HTTP
* Conversion of time to Graphite compatible format
* `TimeSeries` POJO for representing Graphite datasets

## Examples

All resources MUST be prefixed by their scheme. Supported
schemes are `http(s)`, `classpath` (loading files from the resources folder)
and `file`. The format for a resource path is always

    <scheme>://<path>

### High level API

Using the `GraphiteClient` to load `src/main/resources/data.csv`.

    public static GraphiteTimeSeries getWithClient() throws GraphiteConsumptionException {
        String csvData = "classpath://data.csv";
        return new GraphiteClient().getData(new PreparedGraphiteQuery(csvData));
    }

### Parsing CSV files

Parsing `data/data.csv`. 

**NOTE** You must be in the root directory
for this to work.

    public static GraphiteTimeSeries parseCsvFile() throws GraphiteConsumptionException {
        String csvData = Paths.get(".").toAbsolutePath().normalize().toString() + "/data/data.csv";
        CsvTimeSeriesEncoder encoder = new CsvTimeSeriesEncoder();
        LocalFileConsumer fileConsumer = new LocalFileConsumer(encoder);
        GraphiteTimeSeries timeSeries = fileConsumer.get(csvData);
        return timeSeries;
    }

## Todo

* Refactoring the API of `IGraphiteConsumer`
* Robust parsing of resource paths (Http, Local)
* Top-level API via `GraphiteClient`
* Being smart about provided resource paths
* Better unit tests
* JSON support

## Links

* [Graphite HTTP API](https://graphite-api.readthedocs.io/en/latest/api.html#the-render-api-render)
