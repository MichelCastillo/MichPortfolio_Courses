package dataTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clase16_format_parse_LocalDateTime {

    public static void formatLocalDateTime(){
        String dateTime = "2018-04-18T14:33:33";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTime1 = " + localDateTime1);

        //Custom format T
        String dateTimeCustom = "2018-04-18T14|33|33";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss"); //'T'
        LocalDateTime localDateTimeCustom = LocalDateTime.parse(dateTimeCustom, dateTimeFormatter);

        System.out.println("localDateTimeCustom = " + localDateTimeCustom);

        //Custom format abc
        String dateTimeCustomabc = "2018-04-18abc14|33|33";
        DateTimeFormatter dateTimeFormatterabc = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss"); //'abc'
        LocalDateTime localDateTimeCustomabc = LocalDateTime.parse(dateTimeCustomabc, dateTimeFormatterabc);

        System.out.println("localDateTimeCustom abc = " + localDateTimeCustomabc);
    }

    public static void parseLocalDateTime(){
        DateTimeFormatter dateTimeFormatterabc = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss"); //'abc'
        LocalDateTime localDateTime = LocalDateTime.now();
        String convertedDateTime = localDateTime.format(dateTimeFormatterabc);
        System.out.println("convertedDateTime = " + convertedDateTime);

    }

    public static void main(String[] args) {
        formatLocalDateTime();
        System.out.println("//////////////////////////////////");
        parseLocalDateTime();
    }
}
