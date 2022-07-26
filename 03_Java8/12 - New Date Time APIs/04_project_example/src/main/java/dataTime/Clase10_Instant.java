package dataTime;

import java.time.Duration;
import java.time.Instant;

public class Clase10_Instant {

    //Represent the time ina machine readable format

    public static void main(String[] args) {
        Instant instant = Instant.now(); //Represents the time in seconds from January 01,1970(EPOCH) to current time as a huge number
        System.out.println("Instant.now(): " + instant);

        //Jan 1st 1970 -> Epoch -> Como por año existen 86400 segundos, este numero nos devuelve la cantidad de segundos entre esa fecha y la actual
        System.out.println("Instant.getEpochSecond(): " + instant.getEpochSecond());

        System.out.println("Instant.ofEpochSecond(0): " + Instant.ofEpochSecond(0)); //Representa el momento 0, es decir 1ero de Enero de 1970 a las 00.00.00.0000

        //Comparando instants
        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        System.out.println("Duration between instant, in nanoseconds: " + duration.getNano());
    }

}
