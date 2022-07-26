package dataTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clase14_Formatting_LocalDate_DateFormatter {

    //Part of java.time.format package
    //Used to parse and format the LocalDate, LocalTime and LocalDateTime

    //parse - converting a String to a LocalDate, LocalTime or LocalDateTime
    //format - Converting a LocalDate/LocalTime/LocalDateTime to a String

    public static void parseLocalDate(){
        //Converting String to LocalDate
        String date = "2018-04-28";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("localDate (way 1)= " + localDate);

        LocalDate localDate2 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate2 (way 2)= " + localDate2);

        String date2 = "20180428";
        LocalDate localDateOtherFormat = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDateOtherFormat (way 3)= " + localDateOtherFormat);

        //Custom defined dateformat |
        String date3 = "2018|04|28";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDateCustomFormat = LocalDate.parse(date3, dateTimeFormatter);
        System.out.println("localDateCustomFormat (custom format |)= " + localDateCustomFormat);

        //Custom defined dateformat *
        String date4 = "2018*04*28";
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy*MM*dd");
        LocalDate localDateCustomFormat2 = LocalDate.parse(date4, dateTimeFormatter2);
        System.out.println("localDateCustomFormat (custom format *)= " + localDateCustomFormat2);

        //# does not work as separator
    }

    public static void formatLocalDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate = LocalDate.now();
        String date = localDate.format(dateTimeFormatter);
        System.out.println("date = " + date);
    }

    public static void main(String[] args) {

        parseLocalDate();

        System.out.println("//////////////////////////////////");

        formatLocalDate();

    }
}
