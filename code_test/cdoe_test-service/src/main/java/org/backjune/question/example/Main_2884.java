package org.backjune.question.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main_2884 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 입력받은 숫자 지정
        String time = sc.nextLine();
        String[] timeArray = time.split(" ");
        String hour = null;
        String minutes = null;

        if(timeArray[0].length() == 1){
            hour = "0"+timeArray[0];
        }else hour = timeArray[0];

        if(timeArray[1].length() == 1){
            minutes = "0"+timeArray[1];
        }else minutes = timeArray[1];


        String timeResult = getTimeStamp()+hour+minutes+"00";
        String parseResult = setDateStringMinusMonth(timeResult, 45);

        String parseResultSubString = parseResult.substring(8,12);

        String resultHour = parseResultSubString.substring(0,2);
        String resultMin = parseResultSubString.substring(2,4);

        String[] arrHour = resultHour.split("");
        String[] arrMin = resultMin.split("");

        String arrHourResult = null;
        if(arrHour[0].equals("0")){
            arrHourResult = arrHour[1];
        }else{
            arrHourResult = arrHour[0]+arrHour[1];
        }

        String arrMinResult = null;
        if(arrMin[0].equals("0")){
            arrMinResult = arrMin[1];
        }else{
            arrMinResult = arrMin[0]+arrMin[1];
        }

        System.out.println(arrHourResult+" "+arrMinResult);
    }

    public static String getTimeStamp(){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateString = localDateTime.format(formatter);
        return dateString;
    }

    public static String setDateStringMinusMonth(String timeA, long minutes){
        //Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localA = LocalDateTime.parse(timeA, formatter);
        localA = localA.minusMinutes(minutes);
        String dateString = localA.format(formatter);
        return dateString;
    }

}
