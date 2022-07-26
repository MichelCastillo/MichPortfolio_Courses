package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Clase12_LimitAndSkip {

    //limit() and skip()
    //both helps to create substreams

    //limit(n): limits the "n" numbers of elements to be processed in the stream - Ejemplo limit(2) -> solo va a procesar los primeros 2 elementos
    public static Optional<Integer> limit(List<Integer> integers){
        return integers.stream()
                .limit(2)
                .reduce(Integer::sum);
    }


    //skip(n) skips the "n" number of elements from the stream - Supongamos que tenemos skip(3) -> va a ignorar los primeros 3 elementos y procesar el resto
    public static Optional<Integer> skip(List<Integer> integers){
        return integers.stream()
                .skip(3)
                .reduce(Integer::sum);
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        //Using limit
        Optional<Integer> limitValue = limit(integers);
        limitValue.ifPresent(integer -> System.out.println("Limit value: " + integer));

        //Using skip
        Optional<Integer> skipValue = skip(integers);
        skipValue.ifPresent(integer -> System.out.println("Skip value: " +  integer));
    }


}
