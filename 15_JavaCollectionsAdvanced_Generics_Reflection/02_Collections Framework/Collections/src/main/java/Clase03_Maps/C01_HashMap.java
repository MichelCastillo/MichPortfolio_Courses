package Clase03_Maps;

import java.util.HashMap;
import java.util.Map;

public class C01_HashMap {

    public static void main(String[] args) {

        // Not synchronized
        Map<Integer, String> map = new HashMap<>();

        // Insert into the map O(1) if there is NO COLLISION
        map.put(1, "Adam");
        map.put(2, "Adam2");
        map.put(3, "Adam3");
        map.put(4, "Adam4");
        map.put(5, "Adam5");
        /*map.put(null, "This is a null");*/

        // We can retrieve items based on keys O(1)
        System.out.println(map.get(1));

        // Removing items
        map.remove(2);
        map.remove(120); // No pasa nada

        // Iterating over the map
        System.out.println("#################################### KEY SET");
        for (Integer key:
             map.keySet()) {
            System.out.println(map.get(key));
        }

        // La desventaja de los HashMap es que no almacena los datos ordenados a partir de las claves

        // Iterating over entrySetr
        System.out.println("#################################### ENTRY SET");
        for (Map.Entry<Integer, String> entry:
             map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

}
