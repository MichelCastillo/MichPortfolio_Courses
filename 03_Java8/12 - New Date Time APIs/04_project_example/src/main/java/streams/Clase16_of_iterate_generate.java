package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Clase16_of_iterate_generate {

    //of() - create a stream of certain values passed to this method.
    Stream<String> stringStream = Stream.of("Mich", "Micel", "Michel");

    //iterate() & generate() - used to create infinite Streams
    //Stream.iterate(1, x -> x*2)
    //Stream.generate(<Supplier>)

    public static void main(String[] args) {
        //Using of()
        Stream<String> stringStream2 = Stream.of("Mich", "Micel", "Michel");
        stringStream2.forEach(System.out::println);

        //Using iterate
        Stream.iterate(1, x -> x*2) //toma 1, lo multiplica por 2, luego toma ese resultado y lo vuelve a multiplicar por 2, y asi sucesivamente
                .limit(10) //limitamos la salida para que no sea infinito
                .forEach(System.out::println);

        //Using generate
        Supplier<Integer> supplier = new Random()::nextInt;
        Stream.generate(supplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
