package de.teekaay.graphite.query;


import de.teekaay.graphite.IGraphiteQuery;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class TemplatedGraphiteQuery implements IGraphiteQuery {
    public static final String DEFAULT_TEMPLATE = "from=${from}&until=${until}&target=${target}&format=${format}";
    public static final Map<String, String> DEFAULT_VARIABLES = new HashMap<>();
    public static final String PARAM_FROM = "from";
    public static final String PARAM_UNTIL = "until";
    public static final String PARAM_TARGET = "target";
    public static final String PARAM_FORMAT = "format";

    static {
        DEFAULT_VARIABLES.put(PARAM_FROM, "");
        DEFAULT_VARIABLES.put(PARAM_UNTIL, "");
        DEFAULT_VARIABLES.put(PARAM_TARGET, "");
        DEFAULT_VARIABLES.put(PARAM_FORMAT, "");
    }

    private String template;
    private Map<String, String> variables;

    public TemplatedGraphiteQuery() {
        this(DEFAULT_TEMPLATE, DEFAULT_VARIABLES);
    }

    public TemplatedGraphiteQuery(final String template, final Map<String, String> variables) {
        this.template = template;
        this.variables = variables;
    }

    public String render() {
        StrSubstitutor substitutor = new StrSubstitutor(variables);
        String rendered = substitutor.replace(template);
        return rendered;
    }

    public TemplatedGraphiteQuery addVariable(final String key, final String value) {
        variables.put(key, value);
        return this;
    }
}

