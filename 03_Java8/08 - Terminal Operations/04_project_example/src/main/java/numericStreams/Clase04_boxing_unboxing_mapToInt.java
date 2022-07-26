package numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Clase04_boxing_unboxing_mapToInt {

    //Boxing() -> Converting a primitive type to Wrapper Class type
    // - int -> Integer
    public static List<Integer> boxing(){
        //int -> integer
        return IntStream.rangeClosed(1,10)
                .boxed() //int -> Integer
                .collect(Collectors.toList());
    }

    //UnBoxing() -> Converting a Wrapper class type to primitive type
    // - Integer -> int
    public static int unboxing(List<Integer> listInteger){
        //Integer -> int (wrapper to primitive)
        return listInteger.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Boxing: " + boxing());

        System.out.println("Unboxing: " + unboxing(boxing()));
    }

}
