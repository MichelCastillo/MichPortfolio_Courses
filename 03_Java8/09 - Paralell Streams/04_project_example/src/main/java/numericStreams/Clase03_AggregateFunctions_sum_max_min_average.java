package numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Clase03_AggregateFunctions_sum_max_min_average {

    //sum()
    //max()
    //min()
    //average()

    public static void main(String[] args) {
        //Sum
        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("Sum is: " + sum);

        //max
        OptionalInt optionalInteger = IntStream.rangeClosed(1,50).max();
        optionalInteger.ifPresent(value -> System.out.println("OptionalInt Max value: " + value));

        //min
        OptionalLong optionalLongMin = LongStream.rangeClosed(1, 50).min();
        optionalLongMin.ifPresent(value -> System.out.println("OptionalLong Min value: " + value));

        //Average
        OptionalDouble optionalDoubleAverage = IntStream.rangeClosed(1, 50).asDoubleStream().average();
        optionalDoubleAverage.ifPresent(value -> System.out.println("optionalDouble Average value: " + value));

    }
}
