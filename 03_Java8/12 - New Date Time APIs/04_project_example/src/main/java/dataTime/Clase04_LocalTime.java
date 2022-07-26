package dataTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Clase04_LocalTime {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now(); //This machine current time

        //of(hora, minutos)
        System.out.println("Hora actual de la PC: " + localTime);
        System.out.println("LocalTime of(hora, minutos): "+ LocalTime.of(23, 33)); //Obtenemos un objeto de tipo Hora con esos datos

        //of(hora, minutos, segundos)
        System.out.println("LocalTime of(hora, minutos, segundos): "+ LocalTime.of(23, 33, 33)); //Obtenemos un objeto de tipo Hora con esos datos

        //of(hora, minutos, segundos, nanosegundos)
        System.out.println("LocalTime of(hora, minutos, segundos, nanosegundos): "+ LocalTime.of(23, 33, 33, 980980)); //Obtenemos un objeto de tipo Hora con esos datos

        //Using localTime to get data from it
        System.out.println("localTime.getHour(): " + localTime.getHour());

        System.out.println("localTime.getMinute(): " + localTime.getMinute());

        System.out.println("localTime.get(ChronoField.CLOCK_HOUR_OF_DAY): " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

        System.out.println("localTime.toSecondOfDay(): " + localTime.toSecondOfDay()); //Mos devuelve cuantos segundos pasaron hoy

        //Cómo modificar LocalTime
        System.out.println("localTime.minusHours(): " + localTime.minusHours(2)); //Restamos 2 horas a la hora actual
        System.out.println("localTime.minus(): " +  localTime.minus(2, ChronoUnit.HOURS)); //Restamos 2 horas usando minus directamente
        System.out.println("localTime.with(MIDNIGHT): " + localTime.with(LocalTime.MIDNIGHT)); //Cambiamos la hora actual por la hora de hoy a la medianoche
        System.out.println("localTime.with(HOUR_OF_DAY)" + localTime.with(ChronoField.HOUR_OF_DAY, 22)); //Cambiamos la hora para que sean las 22
        System.out.println("localTime.plusMinutes(): " + localTime.plusMinutes(30)); //Agregamos 30 minutos
        System.out.println("localTime.withHour(): " + localTime.withHour(5)); //Agregamos 5 horas a la fecha actual




    }
}
