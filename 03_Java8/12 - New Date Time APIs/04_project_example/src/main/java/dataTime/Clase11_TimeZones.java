package dataTime;

import java.time.*;

public class Clase11_TimeZones {

    //ZonedDateTime, ZoneID, ZoneOffset

    //ZonedDateTime - Represents the date/time with its time zone.

    //ZoneOffset - Offset time from the UTC time

    //ZoneID -> Identifier to which that TimeZone belongs to

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime);

        System.out.println("ZoneOffset: " + zonedDateTime.getOffset());
        System.out.println("ZoneID: " + zonedDateTime.getZone());

        //Lista de las ZoneID disponibles
        //System.out.println("Zone ID availables: " + ZoneId.getAvailableZoneIds());
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        //Cantidad de zonas:
        System.out.println("Cantidad de ZoneIDs: " + ZoneId.getAvailableZoneIds().size());

        //Argentina Time
        System.out.println("Argentina UTC-3: " + ZonedDateTime.now(ZoneId.of("America/Buenos_Aires")));
        System.out.println("Argentina UTC-3 + Clock: " + ZonedDateTime.now(Clock.system(ZoneId.of("America/Buenos_Aires"))));

        //Creando LocalDateTime usando TimeZones
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Buenos_Aires"));
        System.out.println("Creando LocalDateTime usando TimeZones: " + localDateTime);

        //Creando LocalDateTime usando TimeZones - Clock
        LocalDateTime localDateTimeClock = LocalDateTime.now(Clock.system(ZoneId.of("America/Buenos_Aires")));
        System.out.println("Creando LocalDateTime usando TimeZones - Clock: " + localDateTimeClock);

        //Usando Instance
        LocalDateTime localDateTimeInstant = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("Creando LocalDateTime usando Instance: " + localDateTimeInstant);

    }

}
