package dataTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Clase02_Modifiy_LocalDate {

    public static void main(String[] args) {

        //Los LocalDates sin inmutables. Cada vez que se modifica, se crea una nueva isntancia

        LocalDate localDate = LocalDate.now();

        //Modifying Local Date
        System.out.println(localDate.plusDays(2)); //Agregamos 2 días a la fecha actual

        System.out.println("Adding months: " + localDate.plusMonths(2)); //Agregamos 2 meses a la fecha actual

        System.out.println("Minus Days: " + localDate.minusDays(2)); //Sacamos 2 días de la fecha actual

        System.out.println("withYear: " + localDate.withYear(2019)); //Coloca la fecha actual con el año especificado

        System.out.println("with: ChronoField.YEAR" + localDate.with(ChronoField.YEAR, 2020)); //Modificando el año usando el with en lugar del withYear

        System.out.println("with TemporalAdjusters: " + localDate.with(TemporalAdjusters.firstDayOfMonth())); //Primer dia del mes de la fecha actual


    }
}
