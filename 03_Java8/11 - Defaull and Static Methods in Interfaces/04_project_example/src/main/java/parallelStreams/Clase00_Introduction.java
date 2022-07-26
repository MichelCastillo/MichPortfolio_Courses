package parallelStreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Clase00_Introduction {

    //A paralell stream splits the source of data into multiple parts.
    // process them parallelly
    // combine the result

    //How to create a Parallel Stream?
    //Sequential Stream:
    /*
    IntStream.rangeClosed(1,1000)
        .sum();
    */

    //Parallel Stream
    /*
    IntStream.rangeClosed(1,1000)
            .parallel()
            .sum();
    */

    public static long checkPerformanceResult(Supplier<Integer> supplier, int numOfTimes){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfTimes; i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }

    public static int sum_sequential_stream(){
        return IntStream.rangeClosed(1,100000)
                .sum();
    }

    public static int sum_parallel_stream(){
        return IntStream.rangeClosed(1,100000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {

        //System.out.println("Sequential Stream result: " +  sum_sequential_stream());

        //System.out.println("Parallel Stream result: " + sum_parallel_stream());

        //Using those methods as Suppliers
        System.out.println("Sequential Stream performance: " + checkPerformanceResult(Clase00_Introduction::sum_sequential_stream, 20));

        System.out.println("Parallel Stream performance: " + checkPerformanceResult(Clase00_Introduction::sum_parallel_stream, 20));

        //Para saber cuantos hilos se crean para ejecutar esta tarea en paralelo (ya que numero de hilos == numero de procesadores)
        System.out.println("Numero de procesadores: " +  Runtime.getRuntime().availableProcessors());
    }
}
