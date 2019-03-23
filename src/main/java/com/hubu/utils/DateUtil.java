package com.hubu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 功能描述: 日期工具类，格式转换
 *
 * @author : chenfeiliang
 */
public class DateUtil {

    //Date转换为String
    public static String DateTimeToString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");

        String dateString = formatter.format(date);

        return dateString;
    }

    //Date转换为String
    public static String DateToString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = formatter.format(date);

        return dateString;
    }


    //String转换为Date
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

    //String转换为Date
    public static Date StringToDate2(String dt) {

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {

            date = format1.parse(dt);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}
