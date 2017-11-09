package com.xora.util;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */
public class GenerateName {

    public static String generateName(String name){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Greenwich Mean Time"));
        StringBuilder result = new StringBuilder()
                .append(calendar.get(Calendar.YEAR))
                        // calendar returns month from 0 - 11
                .append(padLeft(calendar.get(Calendar.MONTH) + 1, 2))
                .append(padLeft(calendar.get(Calendar.DAY_OF_MONTH), 2))
                .append(padLeft(calendar.get(Calendar.HOUR_OF_DAY), 2))
                .append(padLeft(calendar.get(Calendar.MINUTE), 2))
                .append(padLeft(calendar.get(Calendar.SECOND), 2))
                .append(padLeft(calendar.get(Calendar.MILLISECOND), 3));
        return "Auto"+ name + result;
    }

    public static String padLeft(int value, int digitWidth){
        String s = String.valueOf(value);
        while (s.length() < digitWidth){
            s = "0" + s;
        }
        return s;
    }
}
