package com.springmongo.springmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class URL {

    public static String decodeParam (String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate) {
        LocalDate defaultValue = LocalDate.ofInstant(Instant.now(), ZoneId.of("Etc/UTC"));
        try {
            LocalDate date = LocalDate.parse(textDate);
            return date;
        } catch (RuntimeException error) {
            return defaultValue;
        }


    }
}
