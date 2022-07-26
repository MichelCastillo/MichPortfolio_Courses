package Clase03_Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C05_TreeMap_HashMap_Performance_Comparison {

    public static void main(String[] args) {

        // O(logN)
        Map<Integer, Integer> map = new TreeMap<>();

        long now = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            map.put(i, i);
        };

        for (int i = 0; i < 500000; i++) {
            map.get(i);
        };

        System.out.println("Time taken with TreeMap: " + (System.currentTimeMillis() - now));

        // O(1)
        Map<Integer, Integer> map2 = new HashMap<>();
        now = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            map2.put(i, i);
        };

        for (int i = 0; i < 500000; i++) {
            map2.get(i);
        };

        System.out.println("Time taken with HashMap: " + (System.currentTimeMillis() - now));



    }
}
