package Clase06_CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C01_CollectionClass_Methods {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(10);
        nums.add(5);
        nums.add(8);
        nums.add(2);
        nums.add(3);

        Collections.reverse(nums); // Invertimos el orden de insersión

        //MIN - MAX Finding
        System.out.println("min: " + Collections.min(nums));
        System.out.println("max: " + Collections.max(nums));

        // we an shuffle the underlying collection
        Collections.shuffle(nums); //orden random

        // Rotate list
        Collections.rotate(nums, 1); // Mueve los elementos en "1" hacia adelante (el ultimo termina siendo el primero)

        // Replace items
        Collections.replaceAll(nums, 1, 10); // el 1 va a ser reemplazado por 10

        System.out.println(nums);

    }
}
