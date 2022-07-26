package Clase01_List;

import java.util.LinkedList;
import java.util.List;

public class C02_LinkedList {

    public static void main(String[] args) {

        //Implementation
        LinkedList<Integer> linkedList = new LinkedList<>();

        //Inserting elements
        linkedList.add(1);
        linkedList.add(10);
        linkedList.add(5);
        linkedList.add(3);
        // 1 - 10 - 5 - 3

        //addLast
        linkedList.addLast(50);
        // 1 - 10 - 5 - 3 - 50

        //addFirst
        linkedList.addFirst(100);
        // 100 - 1 - 10 - 5 - 3

        //removeFirst
        linkedList.removeFirst();
        // 1 - 10 - 5 - 3 - 50

        //removeLast
        linkedList.removeLast();
        // 1 - 10 - 5 - 3

        //size
        linkedList.size(); //4

        for (Integer num:
             linkedList) {
            System.out.println(num);
        }

    }

}
