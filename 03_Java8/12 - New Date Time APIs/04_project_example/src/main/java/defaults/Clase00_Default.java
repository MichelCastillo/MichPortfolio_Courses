package defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clase00_Default {
    //Caso de uso: ordenar la lista de nombres alfabéticamente



    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Erick");

        //Prior Java 8
        Collections.sort(stringList); //va a ordenar los nombres alfabeticamente
        System.out.println("Sorted List using Collections: " + stringList);

        //Java 8
        List<String> stringList8 = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Erick");

        stringList8.sort(
                //Comparator.naturalOrder() //Ascending order
                Comparator.reverseOrder() //Descending order
        );
        System.out.println("Sorted List using List.sort(): " + stringList8);

    }
}
