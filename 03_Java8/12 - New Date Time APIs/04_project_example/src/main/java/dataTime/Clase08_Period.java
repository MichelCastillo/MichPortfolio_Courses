package dataTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Clase08_Period {

    //is a date-based representation of time in Days, Months and Years and is aprt of the java.time package
    //Compatible with LocalDate
    //It represents a Period of Time not just a specific date and time

    Period periodExample = Period.ofDays(10); //Representa un período de 10 días
    Period periodExample2 = Period.ofDays(20); //Representa un período de 20 días

    //El caso de uso más común es expresar la diferencia entre dos fechas.
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2018,01,01);
        LocalDate localDate2 = LocalDate.of(2018,12,31);

        //LocalDate.until()
        Period periodUntil = localDate1.until(localDate2);
        System.out.println("LocalDate.until().getDays(): " + periodUntil.getDays()); //30: Solamente nos devuelve cuantos días hay de diferencia, sin contar año y mes
        System.out.println("LocalDate.until().getMonths(): " + periodUntil.getMonths());//11: lo mismo de arriba, pero con los meses
        System.out.println("LocalDate.until().getYears(): " + periodUntil.getYears());//0: lo mismo de arriba, pero en años

        //Périodo de 10 días.
        Period period10days = Period.ofDays(10);
        System.out.println("Period.ofDays(10): " + period10days.getDays());

        //Período de 10 años
        Period period10years = Period.ofYears(10);
        System.out.println("Period.ofYears(10): " + period10years.getYears());

        //Cantidad de meses en un período de 10 años
        System.out.println("Period.ofYears(10).toTotalMonths(): " + period10years.toTotalMonths());

        //Comparando con between
        Period period = Period.between(localDate1, localDate2);
        System.out.println("La diferencia entre ambas fechas es: " + period.getDays() + " días, "
                + period.getMonths() + " meses, "
                + period.getYears() + " años.");

        //PERIOD es compatible con LocalDate, no con LocalTime ni con LocalTimeDate

    }

}
