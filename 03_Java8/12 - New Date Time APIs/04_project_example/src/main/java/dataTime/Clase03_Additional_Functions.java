package dataTime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Clase03_Additional_Functions {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        LocalDate newLocalDate = LocalDate.of(2022, 10, 30);

        System.out.println("LocalDate minusDays: " + localDate.minusYears(1)); //Sacamos 1 año a la fecha actual

        System.out.println("LocalDate minus: " + localDate.minus(1, ChronoUnit.YEARS)); //Sacamos 1 año a la fecha actual con minus

        //LeapYear
        System.out.println("leapyear: " + LocalDate.ofYearDay(2020, 01).isLeapYear());

        //Comparing dates

        //isEqual
        System.out.println("Comapring localDate and newLocalDate: " + localDate.isEqual(newLocalDate));

        //isBefore
        System.out.println("Comparing localDate and newLocalDate checking if the first is before the second one: " + localDate.isBefore(newLocalDate));

        //isAfter
        System.out.println("Comparing localDate and newLocalDate checking if the first is after than the second one: " + localDate.isAfter(newLocalDate));

        //Unsopported
        //System.out.println("Chronounit minus: " + localDate.minus(1, ChronoUnit.MINUTES)); //Tira unsupportedTemporalTypeException
        // - dado que estamos intentando restar minutos a algo de formato Date

        //Para chequear esto:
        System.out.println("isSupported: " + localDate.isSupported(ChronoUnit.MINUTES));

    }
}
