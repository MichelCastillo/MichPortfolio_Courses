package Clase01_List;

import java.util.ArrayList;
import java.util.List;

public class C01_ArrayList {



    public static void main(String[] args) {

        // resizing the array takes O(N)
        List<String> names = new ArrayList<>();

        //Insert items
        names.add("Mich");
        names.add("Nacho");

        //random indexing in O(1)
        System.out.println(names.get(0));

        //Insert item into a given index - O(N)
        names.add(0, "MERCEDES");
        names.remove(0);

        //contains will check wether the item is present in the array - O(N)
        System.out.println(names.contains("Adam"));

        //to Array
        Object[] os = names.toArray();

         // ARRAYLIST - Are fast if we manipulate the last item but not if we manipulate arbitrary indexes

        //Podemos usar este foreach gracias a que Arraylist extiende desde Iterable
        for (String s:
             names) {
            System.out.println(s);
        }


    }
}
