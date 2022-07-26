package Clase02_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class C03_ArrayDeque {

    public static void main(String[] args) {

        // double ended queue (DEQUE)
        // huge one dimensional arrays - O(1)
        System.out.println("####################################### DEQUE");
        Deque<Integer> queue = new ArrayDeque<>();

        //offer -> funciona como el add (FIFO)
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        //poll() -> va sacando elementos desde el inicio.
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        /*queue.forEach(System.out::println);*/

        System.out.println("####################################### STACK");
        Deque<Integer> stack = new ArrayDeque<>();

        //push() -> va agregando elementos como si fuese una pila  (LIFO)
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        /*stack.forEach(System.out::println);*/

        //pop() -> va sacando elementos desde el final.
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
