package optional;

import java.util.Optional;

public class Clase01_empty_ofNullable_of {

    //ofNullable -
    public static Optional<String> ofNullable(){
        //Vamos a usar este método cuando no estamos seguro si este String va a ser "valido" todo el tiempo (!= null
        return Optional.ofNullable("Hello");
    }

    //of() -
    public static Optional<String> of(){
        return Optional.of("Hello");
    }

    //of() -
    public static Optional<String> empty(){
        //Esto solo nos devuelve un objeto de tipo Optional.empty
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("ofNullable(): " + ofNullable().get());

        //La diferencia radica en que el of() cuando recibe un null, va a devolver un NullPointerException
        System.out.println("of(): " +  of().get());

        System.out.println("empty(): " + empty());
    }
}
