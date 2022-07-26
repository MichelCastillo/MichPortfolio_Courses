package numericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Clase02_NumericStreamRanges {

    //Numeric Streams are used to represent the primitive values in a Stream
    // - IntStream
    // IntStream.range(1,50) -> returns an IntStream of 49 elements from 1 to 49
    // IntStream.rangeClosed(1,50) -> returns an IntStream of 50 elements from 1 to 50


    // - LongStream
    // LongStream.range(1,50) -> returns a LongStream of 49 elements from 1 to 49
    // LongStream.rangeClosed(1,50) -> returns a LogStream of 50 elements from 1 to 50

    // - DoubleStream
    // - it does not support the range() and rangeClosed()

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1, 50);
        //Cantidad de elementos: 49
        System.out.println(intStream.count());

        //Debido a que un stream se puede "usar" solo una vez, debemos de crear otro si quermos recorrerlo para obtener su contanido
        System.out.println("IntStream Range: ");
        IntStream.range(1, 50).forEach(integer -> System.out.print(integer + ", "));

        System.out.println("\nIntStream Range Closed: ");
        IntStream.rangeClosed(1, 50).forEach(integer -> System.out.print(integer + ", "));

        //LongStream
        System.out.println("\nLongStream Range: ");
        LongStream.range(1, 50).forEach(integer -> System.out.print(integer + ", "));

        System.out.println("\nLongStream Range Closed: ");
        LongStream.rangeClosed(1, 50).forEach(integer -> System.out.print(integer + ", "));

        //DoubleStream
        //Si biene ste no soporta los metodos range, ni rangeClosed, usamos IntStream y lo transformamos a DoubleStream
        System.out.println("\nDoubleStream Range: ");
        IntStream.range(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ", "));


    }
}
