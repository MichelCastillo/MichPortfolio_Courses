package Clase02_Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class C02_PriorityQueue {

    /*
     *
     * Based on a priority heap -
     *   We assign a priority value to every single items
     *       - element with high priority is served before an element with low priority
     *       - the elements of the priority queue are ordered according to their natural ordering defined by the Comparable Interface
     *
     * add()  -> add elements to the queue
     * peek() -> Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * poll() -> Retrieves and removes the head of this queue, or returns null if this queue is empty
     *
     * */

    public static void main(String[] args) {

        Queue<Person> queue = new PriorityQueue<>();

        //Inserting elements
        queue.add(new Person("Mich", 25));
        queue.add(new Person("Nacho", 22));
        queue.add(new Person("Agustin", 20));
        queue.add(new Person("Santi", 15));

        // Para poder hacer esto, la clase Person debe implementar Comparable
        while (queue.peek() != null){
            System.out.println(queue.poll().toString());
        }

    }
}
