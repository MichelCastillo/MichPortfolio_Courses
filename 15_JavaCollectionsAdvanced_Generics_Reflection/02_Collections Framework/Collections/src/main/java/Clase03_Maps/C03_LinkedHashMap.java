package Clase03_Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C03_LinkedHashMap {

    public static void main(String[] args) {

        //There is a doubly linked list connecting the inserted items
        Map<String, Integer> map = new LinkedHashMap<>(); // Su ventaja es que nos permite conservar el orden de inserción

        map.put("aaa", 1);
        map.put("bbb", 2);
        map.put("ccc", 3);
        map.put("ddd", 4);
        map.put("eee", 5);

        for (String key:
             map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }

    }

}
