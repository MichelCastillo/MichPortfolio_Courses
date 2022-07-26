package dataTime;

import java.time.*;

public class Clase12_InstantLocalDateTime_To_ZonedDateTime {

    public static void main(String[] args) {

        //Converting from LocalDateTime, instant to ZonedLocalTime and Time

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime1);

        //From LocalDateTime
        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.of("America/Buenos_Aires"));
        System.out.println("LocalDateTime: " + zonedDateTime1);

        //From Instant
        ZonedDateTime zonedDateTimeInstant = Instant.now().atZone(ZoneId.of("America/Buenos_Aires"));
        System.out.println("Insant: " + zonedDateTimeInstant);

        //From Instant - Offset
        OffsetDateTime offsetDateTime = localDateTime1.atOffset(ZoneOffset.ofHours(-3));
        System.out.println("OffsetDateTime: " + offsetDateTime);
    }
}
