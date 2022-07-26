package Clase04_Set;

import java.util.HashSet;
import java.util.Set;

public class C01_HashSet {

    public static void main(String[] args) {

        // initial capacity = 16
        // hashCode funtion (hash-function) transforms the input into an array index
        // O(1) + memory heavy
        // There may be collisions - O(logN)
        Set<String> set = new HashSet<>();

        set.add("Adam");
        set.add("Mich");
        set.add("Katy");
        set.add("Ana");
        set.add("Ana");

        Set<String> set2 = new HashSet<>();
        set2.add("Adam");
        set2.add("Ana");

        // retainAll(set) -> retendra a los objetos de set que estén en set2
        set.retainAll(set2);

        // remove
        set.remove("Adam");

        //containsAll
        System.out.println(set.containsAll(set2));

        //removeAll
        set.removeAll(set2);

        for (String s : set) {
            System.out.println(s);
        }
    }

}
