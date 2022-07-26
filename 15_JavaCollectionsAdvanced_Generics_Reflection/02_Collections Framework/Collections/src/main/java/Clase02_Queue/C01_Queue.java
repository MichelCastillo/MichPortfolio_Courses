package Clase02_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class C01_Queue {

    public static void main(String[] args) {

        // Implementation
        Queue<String> queue = new LinkedList<>();

        //Inserting elements - FIFO - O(1)
        queue.add("Mich");
        queue.add("Nacho");
        queue.add("Igancio");
        queue.add("Santi");
        queue.add("Agus");

        // Removing elements
        System.out.println("Removing items: " + queue.remove());

        //Checking element
        System.out.println("Check item: " + queue.element()); //cheque el siguiente elemento a salir

        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("#####################################");
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }


    }
}
