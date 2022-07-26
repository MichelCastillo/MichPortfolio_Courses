import java.util.stream.IntStream;

public class ImperativeVSDeclarativeExample1 {

    public static void main(String[] args) {

        // Ejemplo 1: Sumar los valores del 1 al 100;

        // Imperative - how style of programming
        
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += 1;
        }

        System.out.println("Sum using Imperative approach: " + sum);

        // Declarative Style of programming - what style of progrramming

        //rangeClosed(A, B) -> A: limite inferior, B: limite superior ambos incluidos
        sum = IntStream.rangeClosed(0, 100)
                .parallel() //indicamos que se va a ejecutar en entornos de hilos paralelos, en donde esta operacion se ejecuta por trozos
                .sum();

        System.out.println("Sum using Declarative approach: " + sum);

        
    }

}
