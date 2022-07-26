package dataTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clase15_format_parse_localTime {

    public static void parseTime(){

        String time = "13:00";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("localTime.parse(time) = " + localTime);

        LocalTime localTime2 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTime2.parse(time, DateTimeFormatter.ISO_LOCAL_TIME) = " + localTime2);

        //Custom defined format
        String timeCustom = "13*00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH*mm");
        LocalTime localTimeCustom = LocalTime.parse(timeCustom, dateTimeFormatter);
        System.out.println("localTimeCustomFormat = " + localTimeCustom);

        String time2 = "13*00*02";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime3 = LocalTime.parse(time2, dateTimeFormatter1);
        System.out.println("localTimeCustom* = " + localTime3);

    }

    public static void formatTime(){
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime = LocalTime.now();

        String date = localTime.format(dateTimeFormatter1);
        System.out.println("date from LocalTime using DateTimeFormatter = " + date);
    }

    public static void main(String[] args) {
        parseTime();

        System.out.println("///////////////////////////////");

        formatTime();
    }
}
