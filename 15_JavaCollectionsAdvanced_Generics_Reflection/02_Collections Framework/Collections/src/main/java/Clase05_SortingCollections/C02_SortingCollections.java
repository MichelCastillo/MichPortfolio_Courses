package Clase05_SortingCollections;

import java.util.*;

public class C02_SortingCollections {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Adam");
        list.add("Joe");
        list.add("Katy");
        list.add("Ana");

        //Natural Order
        /*Collections.sort(list);*/

        // Reverse Order
        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list);

        System.out.println("####################################### QUEUE");
        // No es posible con Queue
        List<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(20);
        queue.add(4);
        queue.add(13);

        Collections.sort(queue);

    }

}
