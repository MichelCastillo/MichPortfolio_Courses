package Clase06_CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C03_SyncrhonizedCollections {

    public static void main(String[] args) {

        // add() and remove() methods are synchronized
        // intrinsic lock - not that efficient because threads have to wait for each other even when the want to execute independent methods (operations)
        // Efficient solution -> CONCURRENT COLLECTIONS
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());

        // multiple threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    nums.add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    nums.add(i);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of the array: " + nums.size()); //out of bounds -> intentan agregar mas de los 1000 elementos, por eso lo declaramos como syncronizedList

    }
}
