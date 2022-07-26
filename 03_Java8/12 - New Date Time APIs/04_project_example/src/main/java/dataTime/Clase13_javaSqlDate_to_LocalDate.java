package dataTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Clase13_javaSqlDate_to_LocalDate {

    public static void main(String[] args) {
        
        //java.util.Date to LocalDate
        Date date = new Date();
        System.out.println("date = " + date);
        
        LocalDate localDateFromUtilDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("localDateFromUtilDate = " + localDateFromUtilDate);

        //LocalDate -> java.util.Date
        Date date1 = Date.from(localDateFromUtilDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date1 = " + date1);
        
        //java.sql.Date to LocalDate
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDateFromUtilDate);
        System.out.println("sqlDate = " + sqlDate);

        //LocalDate to java.sql.Date
        LocalDate localDateFromSqlDate = sqlDate.toLocalDate();
        System.out.println("localDateFromSqlDate = " + localDateFromSqlDate);
        
    }
}
