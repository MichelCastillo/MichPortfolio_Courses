package Clase04_Set;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class C03_TreeSet {

    public static void main(String[] args) {

        // Implementation
        // O(LogN)
        // MEMORY FRIENDLY
        SortedSet<Integer> set = new TreeSet<>(); // new TreeSet<>(Comparator.reverseOrder());

        //Insertion -> O(logN)
        set.add(12);
        set.add(1);
        set.add(9);
        set.add(5);
        set.add(120);
        set.add(87);

        // Creating subsets -> va a meter en el subset los numeros entre 1 y 5 (no inclusive este ultimo)
        Set<Integer> subSet = set.subSet(1, 5); // 1

        // tailSet -> devuelve los elementos desde el parametro en adelante (inclusive)
        Set<Integer> subSet2 = set.tailSet(5); // 5 - 9 - 12 - 87 - 120

        // headSet -> devuelve los elementos menores al paremtro (no inclusive)
        Set<Integer> subSet3 = set.headSet(12);

        // first
        System.out.println("First: " + set.first());

        // last
        System.out.println("Last: " + set.last());

        for (Integer integer : subSet3) {
            System.out.println(integer);
        }


    }
}
