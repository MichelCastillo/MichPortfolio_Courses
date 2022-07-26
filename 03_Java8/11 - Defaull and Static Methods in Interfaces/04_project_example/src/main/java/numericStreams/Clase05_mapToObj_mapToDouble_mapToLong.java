package numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Clase05_mapToObj_mapToDouble_mapToLong {

    //mapToObj() -> Convert each element numeric stream to some Object
    public static List<Integer> mapToObj(){
        return IntStream.rangeClosed(1,5)
                //Convertimos una IntStream en una lista de Integer
                .mapToObj(i -> {
                    return new Integer(i);
                })
                .collect(Collectors.toList());
    }

    // mapToDouble() -> Convert a numeric Stream to a Long Stream
    public static Double mapToDouble(){
        return IntStream.rangeClosed(1,5)
                .mapToDouble(i -> i) //convert IntStream to DoubleStream
                .sum();
    }

    // mapToLong() -> Convert a numeric Stream to a Double Stream
    public static long mapToLong(){
        return IntStream.rangeClosed(1,5)
                .mapToLong(i -> i) //convert IntStream to LongStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("mapToObject: " + mapToObj());
        System.out.println("mapToLong: " + mapToLong());
        System.out.println("mapToDouble: " + mapToDouble());
    }
}
