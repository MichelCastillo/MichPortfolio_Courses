package numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Clase01_NumericStream {

    //Numeric Streams are used to represents the primitive values in a Stream
    // - IntStream
    // IntStream.range(1,50) -> returns an IntStream of 49 elements from 1 to 49
    // IntStream.rangeClosed(1,50) -> returns an IntStream of 50 elements from 1 to 50


    // - LongStream
    // LongStream.range(1,50) -> returns a LongStream of 49 elements from 1 to 49
    // LongStream.rangeClosed(1,50) -> returns a LogStream of 50 elements from 1 to 50

    // - DoubleStream
    // - it does not support the range() and rangeClosed()

    public static int sumOfNumbers(List<Integer> integerList){
        return integerList.stream()
                .reduce(0, Integer::sum);// por detras, se esta haciendo un unboxing para convertin el wrapper Integer a int
    }

    //Evitarmos ese unboxing
    public static int sumOfNumbersIntStream(List<Integer> integerList){
        return IntStream.rangeClosed(1, 8) // [1,2,3,4,5,6,7,8]
                .sum();
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("Sum of N Numbers: " + sumOfNumbers(integerList));
        System.out.println("Sum of N Numbers IntStream: " + sumOfNumbersIntStream(integerList));

    }

}
