package Clase04_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class C02_LinkedHashSet {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Mich");
        set.add("Nacho");
        set.add("Agustin");
        set.add("Santi");

         // NO ORDER

        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("####################################### LINKED HASH SET");

        // LinkedHashSet maintains the insertion order
        // double linked list connecting the items
        // It needs more memory than hashsets
        Set<String> setOrder = new LinkedHashSet<>();
        setOrder.add("Mich");
        setOrder.add("Nacho");
        setOrder.add("Agustin");
        setOrder.add("Santi");

        for (String s : setOrder) {
            System.out.println(s);
        }
    }
}
