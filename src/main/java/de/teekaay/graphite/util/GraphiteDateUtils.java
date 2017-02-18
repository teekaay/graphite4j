package de.teekaay.graphite.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GraphiteDateUtils {
    public static final String HHMM_YYMMDD = "hhmm_yyyyMMdd";

    public static String convertToHMYMD(LocalDateTime date) {
        return convertToGraphiteDate(date, HHMM_YYMMDD);
    }

    public static String convertToGraphiteDate(LocalDateTime date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
