package com.andremartins.workshopmongo.resources.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {

            LocalDate date = LocalDate.parse(textDate,fmt);
            return date;

            //return fmt.format(new LocalDate.parse(textDate));
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }

    }

