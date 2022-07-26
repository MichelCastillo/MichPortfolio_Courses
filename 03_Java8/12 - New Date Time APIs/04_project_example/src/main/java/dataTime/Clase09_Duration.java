package dataTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Clase09_Duration {

    //Time based representation of time in hours, minutes, seconds and nanoseconds.
    //Compatible with LocalTime and LocalDateTime
    //It represents a duration of time not just a specific time

    public static void main(String[] args) {
        Duration duration1 = Duration.ofHours(3);//duración de 3 horas
        Duration duration2 = Duration.ofMinutes(3);//Duración de 3 minutos

        //Caso de uso: calculo de diferencia entre objetos de tipo LocalTime y LocalDateTime
        LocalTime localTime1 = LocalTime.of(7,20);
        LocalTime localTime2 = LocalTime.of(8, 20);

        //Usando until
        long diff = localTime1.until(localTime2, ChronoUnit.MINUTES);//(LocalTime con el que queremos comparar, Unidad en la que queremos comparar)
        System.out.println("LocalTIme.until(): " + diff);

        //Usando Duration
        Duration duration = Duration.between(localTime1, localTime2);
        System.out.println("Duration.between(): " + duration.toHours() + "hours");

        //Factory methods
        Duration duration3hours = Duration.ofHours(3); //Duracion de 3 horas;
        System.out.println("Duration.ofHours(): " + duration3hours);

        //Duration solamente es compatible entre LocalTime y LocalDateTime
        //LocalDate localDate1 = LocalDate.now();
        //LocalDate localDate2 = LocalDate.now().plusDays(10);
        //Duration durationLocalDates = Duration.between(localDate1, localDate2);

        //System.out.println("Duration with LocalDates: " + durationLocalDates); //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds


    }

}
