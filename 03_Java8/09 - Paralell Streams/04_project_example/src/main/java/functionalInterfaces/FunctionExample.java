package functionalInterfaces;

import java.util.Locale;
import java.util.function.Function;

public class FunctionExample {

    //Function<I, O> : I: input type, O: Output type

    static Function<String, String> function = name -> name.toUpperCase();
    static Function<String, String> addSomeString = name -> name.toUpperCase().concat("default");

    public static void main(String[] args) {

        //Usamos el método apply para aplicar la funcionalidad de la funcion
        System.out.println("Result is: " +  function.apply("java8"));

        //Using andThen -> aplica function a java8 y luego ejecuta la funcion addSomeString para agregarle el default al final
        System.out.println("Result is: " +  function.andThen(addSomeString).apply("java8"));

        //Using compose -> Aplica toda la funcion a los elementos addSomeString y java8 -> componse se ejecuta SOBRE function
        System.out.println("Result is: " +  function.compose(addSomeString).apply("java8"));


    }

}
