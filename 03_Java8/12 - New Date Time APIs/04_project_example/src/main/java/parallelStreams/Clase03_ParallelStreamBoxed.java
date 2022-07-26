package parallelStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Clase03_ParallelStreamBoxed {

    //Cuando no usamos parallel Stream? - Example 1

    public static int sequentialSum(List<Integer> integerList){
        long start = System.currentTimeMillis();

        int sum = integerList.stream()
                .reduce(0, Integer::sum);

        System.out.println("SEQUENTIAL - " + (System.currentTimeMillis() - start));
        return sum;
    }

    public static int parallelSum(List<Integer> integerList){
        long start = System.currentTimeMillis();

        int sum = integerList.stream()
                .reduce(0, Integer::sum);

        System.out.println("PARALLEL - " + (System.currentTimeMillis() - start));
        return sum;
    }

    //Cuando no usamos parallel Stream? - Example 2

    public static void main(String[] args) {
        List<Integer> integerList = IntStream.range(1,10000)
                .boxed()
                .collect(Collectors.toList());

        sequentialSum(integerList);
        parallelSum(integerList);
    }
}
