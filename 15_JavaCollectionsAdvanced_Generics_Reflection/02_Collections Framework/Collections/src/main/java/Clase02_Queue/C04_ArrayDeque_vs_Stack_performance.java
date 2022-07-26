package Clase02_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class C04_ArrayDeque_vs_Stack_performance {

    /*
    because Stack is synchronized (because it extends the Vector class)
    this is why it is going to be slower than the ArrayDeque solution.
    So it is advisable to use ArrayDeque if we are after a LIFO structure.
    */

    public static void main(String[] args) {
        System.out.println("####################################### DEQUE");
        Deque<Integer> stack = new ArrayDeque<>();

        long now = System.currentTimeMillis();

        for(int i=0;i<50000000;i++)
            stack.push(i);

        while(!stack.isEmpty())
            stack.pop();

        System.out.println("Time taken with ArrayDeque: " +
                (System.currentTimeMillis()-now) + "ms");

        System.out.println("####################################### STACK");
        Stack<Integer> stack2 = new Stack<>();

        now = System.currentTimeMillis();

        for(int i=0;i<50000000;i++)
            stack2.push(i);

        while(!stack2.isEmpty())
            stack2.pop();

        System.out.println("Time taken with Stack: " +
                (System.currentTimeMillis()-now) + "ms");

    }
}
