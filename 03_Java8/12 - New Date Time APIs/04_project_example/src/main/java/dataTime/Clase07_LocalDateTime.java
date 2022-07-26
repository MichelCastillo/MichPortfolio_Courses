package dataTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Clase07_LocalDateTime {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("LocalDataTime.now(): " + localDateTime);
        //LocalDateTime.of()
        System.out.println("LocalDateTime.of():" + LocalDateTime.of(2018, 3, 21, 23, 33, 33, 978));
        System.out.println("LocalDateTime.of(LocalDate.now(), LocalTime.now()): " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        //Getting values from LocalDateTime
        System.out.println("Hour: " + localDateTime.getHour());
        System.out.println("Minute: " + localDateTime.getMinute());
        System.out.println("Day: " +  localDateTime.getDayOfMonth()); //Día del mes
        System.out.println("get(ChronoField.DAY_OF_MONTH:): " + localDateTime.get(ChronoField.DAY_OF_MONTH)); //mismo que arriba pero de otra forma

        //Modifying values on LocalDateTime
        System.out.println("PlusHours: " + localDateTime.plusHours(2));
        System.out.println("minusDays: " + localDateTime.minusDays(2));
        System.out.println("localDateTime.withMonth(): " + localDateTime.withMonth(12)); //Nos ubica en el mes de diciembre

        //Convert LocalDate and LocalTime -> LocalDateTime
        LocalDate localDate = LocalDate.of(2019, 1, 1);
        System.out.println("atTime: " + localDate.atTime(23, 12));

        LocalTime localTime = LocalTime.of(23, 39);
        System.out.println("LocalTime.atDate(): " + localTime.atDate(localDate));

        //Converting
        LocalDateTime localDateTime1 = localTime.atDate(localDate);
        System.out.println("atLocalDate: " + localDateTime1.toLocalDate());
        System.out.println("atLocalTime: " + localDateTime1.toLocalTime());

    }
}
