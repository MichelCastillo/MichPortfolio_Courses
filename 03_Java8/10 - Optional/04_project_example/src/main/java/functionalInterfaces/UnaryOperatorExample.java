package functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    //Esta interfaz extiende de Function
    //El input y el output de este unaryOperator va a ser String
    //Podemos usar este tipo de funciones cuando el tipo de la entrada y de la salida son el mismo (por lo cual no hay necesidad de usar functions)
    static UnaryOperator<String> unaryOperator = s -> s.concat("Default");

    public static void main(String[] args) {
        //Usamos el método apply para llamar al unaryOperator
        System.out.println(unaryOperator.apply(("Java8")));
    }

}
