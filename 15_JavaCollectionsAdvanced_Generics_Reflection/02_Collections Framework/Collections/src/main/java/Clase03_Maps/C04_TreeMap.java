package Clase03_Maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class C04_TreeMap {

    public static void main(String[] args) {

        // O(1) < O(logN)
        TreeMap<Integer, String> map = new TreeMap<>();

        /*Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder()); -> orden inverso */

        map.put(10, "ten");
        map.put(3, "three");
        map.put(5, "five");
        map.put(1, "one");
        map.put(8, "eight");

        System.out.println("Largest key (Tree map interface) -> " + map.lastKey());
        System.out.println("Smallest key (Tree map interface) -> " + map.firstKey());

        //Se encuentran ordenados por las keys
        for (Map.Entry<Integer, String> entry:
             map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
