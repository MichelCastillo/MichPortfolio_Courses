package Clase06_CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C02_UnmodifiableCollections {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        nums.add(10);
        nums.add(20);
        nums.add(30);

        //modify(nums);
        // Como estamos en un entorno static, esta operacion va a ser posible, pero para evitarlo

        nums = Collections.unmodifiableList(nums); // con esto, solamente operaciones de lectura van a poder ejecutarse
        //modify(nums);
        nums.add(4);

        System.out.println(nums);

    }

    public static void modify(List<Integer> list){
        list.remove(0);
    }
}
