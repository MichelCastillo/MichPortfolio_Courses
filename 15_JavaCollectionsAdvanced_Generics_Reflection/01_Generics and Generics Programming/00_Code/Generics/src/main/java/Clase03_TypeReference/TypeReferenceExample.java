package Clase03_TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeReferenceExample {

    @SafeVarargs
    static <T> List<T> add(List<T> list, T... item){
        list.addAll(Arrays.asList(item));
        return list;
    }

    public static void main(String[] args) {

        List<Integer> list1 = add(new ArrayList<>(), 20, 30,54, 123,213, 423, 5);
        list1.forEach(System.out::println);
        /*
        * Cómo sabe Java que el array List va a almacenar Integer?
        * Basicamente lo infiere de la declaración del método add
        * */

    }

}
