package com.jeongho.template.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TimeFormatUtil {

    /**
     * 현재 시간을 기준으로 입력 minute 만큼 과거 시간을 리턴
     */
    public static String getDateStringMinusMinute(long minute) {
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.now().minusMinutes(minute).format(formatter);
    }

    /**
     * 현재 시간을 기준으로 입력 minute 만큼 미래 시간을 리턴
     */
    public static String getDateStringPlusMinute(long minute){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.now().plusMinutes(minute).format(formatter);
    }

    /**
     * 현재 시간을 yyyyMMddHHmmss 포맷으로 리턴
     */
    public static String getTimeStamp(){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.now().format(formatter);
    }


    /**
     * 주어진 시간에서 원하는 과거 month 만큼 return
     */
    public static String setDateStringMinusMonth(String time, long month){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.parse(time, formatter).minusMonths(month).format(formatter);
    }

    /**
     * 주어진 시간에서 원하는 미래 month 만큼 return
     */
    public static String setDateStringPlusMonth(String time, long month){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.parse(time, formatter).plusMonths(month).format(formatter);
    }

    /**
     * 주어진 시간에서 원하는 과거 year 만큼 return.
     */
    public static String setDateStringMinusYear(String time, long year){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.parse(time, formatter).minusYears(year).format(formatter);
    }

    /**
     * 주어진 시간에서 원하는 미래 year 만큼 return.
     */
    public static String setDateStringPlusYear(String time, long year){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return LocalDateTime.parse(time, formatter).plusYears(year).format(formatter);
    }

    /**
     * 주어진 일시에서 (yyyyMMddHHmmss) 기준으로 월에 해당되는 last day return
     */
    public static String getLastDayOfMonth(String timeA){
        // Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return String.valueOf(LocalDateTime.parse(timeA, formatter).getMonth().maxLength());
    }

    public static String test(){

        return null;
    }

}
