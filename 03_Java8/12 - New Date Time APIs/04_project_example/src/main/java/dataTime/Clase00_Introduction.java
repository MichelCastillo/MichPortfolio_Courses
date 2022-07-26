package dataTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Clase00_Introduction {



    public static void main(String[] args) {
        //All of these are part of java.time package

        //LocalDate -> Nos devuelve la fecha y la hora de nuestra computadora
        LocalDate localDate = LocalDate.now();
        System.out.println("PC LocalDate: " + localDate);

        //LocalTime -> Nos devuleve la hora actual de la computadora
        LocalTime localTime = LocalTime.now();
        System.out.println("PC LocalTime: " + localTime);

        //LocalDateTime -> devuelve ambas
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("PC LocalDateTime: " + localDateTime);
    }
}
