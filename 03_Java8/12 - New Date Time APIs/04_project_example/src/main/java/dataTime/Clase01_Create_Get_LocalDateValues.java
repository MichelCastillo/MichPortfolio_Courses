package dataTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Clase01_Create_Get_LocalDateValues {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        System.out.println("Normal LocalDate: " + localDate);

        //of
        LocalDate localDateOf3 = LocalDate.of(2018, 07,17); //Esto va a devolver una instancia de LocalDate con esos datos
        System.out.println("LocalDate with of(): " + localDateOf3);

        //offYearDay
        LocalDate localDateOfYear = LocalDate.ofYearDay(2018, 365); //Esto nos devuelve la fecha en el día y en año especificados
        System.out.println("LocalDate ofYearDay: " + localDateOfYear);

        //Get values from localDate - como sacar el dia, el mes, o el año
        System.out.println("LocalDate getMonth(): " + localDate.getMonth()); //Esto nos devuelve el nombre del mes en el que estamos

        System.out.println("LocalDate getMonthValue(): " + localDate.getMonthValue()); //Esto nos devuelve el numero del mes en el que estamos

        System.out.println("LocalDate getDayOfWeek(): " + localDate.getDayOfYear()); //Esto nos devuelve el nombre del día

        System.out.println("LocalDate getDayOfYear(): " + localDate.getDayOfYear()); //Esto nos devuelve el numero del día con respecto al año

        System.out.println("LocalDate Day of the Month(): " + localDate.get(ChronoField.DAY_OF_MONTH));



    }
}
