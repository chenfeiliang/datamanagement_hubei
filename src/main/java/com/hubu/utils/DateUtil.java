package com.hubu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String DateTimeToString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateString = formatter.format(date);

        return dateString;
    }

    public static String DateToString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = formatter.format(date);

        return dateString;
    }

    public static Date StringToDate(String dt) {

        DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd/HH:mm");

        Date date = null;

        try {

            date = format1.parse(dt);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }
}
