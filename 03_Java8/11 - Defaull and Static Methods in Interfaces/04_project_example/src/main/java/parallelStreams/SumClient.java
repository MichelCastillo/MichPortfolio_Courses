package parallelStreams;

import java.util.stream.IntStream;

public class SumClient {

    //Con esto queremos notar que, cuando tenemos "mutable data" es mejor no usar parallel

    public static void main(String[] args) {
        Sum sum = new Sum();

        IntStream.rangeClosed(1,1000)
                .parallel() //494637 - 492864 - 492207 always a different result
                .forEach(sum::performSum);

        System.out.println(sum.getTotal());
    }

}
