package Clase04_Wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_Exercise {

    // Recordar: cuando me digan "DE CUALQUIER TIPO" hace referencia a Generics

    /*

    There is the so-called get and put principle
        - use UPPER BOUNDED WILDCARD (extends) when you only get values out of a structure or collection
        - use LOWER BOUNDED WILDCARD (super) when you only put values into a structure or collection

     DO NOT USE WILDCARDS (?) if you want to read and write as well
        - we can use bounded type parameters in these cases

     There is a popupal misconceptiona bout upper bounded wildcards
        - it does not provide immutability - method(List<? extends T>)
        - it's true that we can not add items to this list but WE MAY ADD NULL or we may apply other operations (for example, sorting)

     WILDCARDS VS BOUNDED TYPES

     Wildcards:
        - we do not have access to the actual type (unknown type)
        - wildcards can handle a single bound (extends or super)
        - we should use wildcards whenever possible

     Bounded Types:
        - we can access the T generic type
        - bounded type parameters can handle multiple bounds
        - we should use bounded type parameters if we want to read and write as well
    */

    public static <T> void copyItems(List<? extends T> source,
                                     List<? super T> target){
        target.addAll(source);
    }

    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> target = new ArrayList<>();

        copyItems(source, target);
        target.forEach(System.out::println);
    }

}
