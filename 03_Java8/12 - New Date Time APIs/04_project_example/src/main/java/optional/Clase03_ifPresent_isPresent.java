package optional;

import java.util.Optional;

public class Clase03_ifPresent_isPresent {

    public static void main(String[] args) {

        //isPresent - chequea si el valor optional es null, y devuelve su valor de verdad
        Optional<String> optional = Optional.ofNullable("Hello Optional");
        if (optional.isPresent()){
            System.out.println(optional.get());
        }

        //ifPresent - casi lo mismo que el isPresent - nada mas que recibe como parámetro un Consumer(con parametro sin return)
        // básicamente chequea si optional tiene un valor, y si es positivo, lleva a cabo la ejecución de ese consumer
        optional.ifPresent(System.out::println);

    }
}
