package Clase04_Wildcards.C01_shapes_example;

import java.util.Arrays;
import java.util.List;

public class C01_UnboundedWildcard {

    /*
    *
    * Object is the parent class of Integer
    *
    * */

    public static void print(Object o){
        System.out.println("Object = " + o.toString());
    }

    public static void printCollection(List<Object> list){
        for (Object element:
             list) {
            System.out.println(element.toString());
        }
    }

    public static void printCollectionCorrect(List<?> list){
        for (Object element:
                list) {
            System.out.println(element.toString());
        }
    }

    public static void main(String[] args) {

        Integer i = 23;
        print(i);
        // Esto funciona por que Integer extiende de Object

        /*
        List<Integer> numeros = Arrays.asList(1, 2, 3);
        printCollection(numeros); //No funciona dado que List<Integer> no es un subtipo de List<Object>
        */
        List<Integer> numeros = Arrays.asList(1, 2, 3);
        printCollectionCorrect(numeros);

        List<String> listString = Arrays.asList("Mich", "Agustin", "Nacho");
        printCollectionCorrect(listString);



    }
}
