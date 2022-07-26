package Clase02_List_ArrayList_LinkedList_Vector_Stack_Cursors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clase01_ArrayList {


    public static void main(String[] args) {

        // Sintaxis
        //Usando interface
        List alList = new ArrayList();

        //Constructor 1
        ArrayList al = new ArrayList();

        //Dando un tamaño inicial al ArrayList
        ArrayList al2 = new ArrayList(30);

        // Constructor 3 - pasando una colección por parametro
        ArrayList al3 = new ArrayList(Arrays.asList(1, 2, 3));

        // Agregando elementos de diferente tipo
        al.add("Mich");
        al.add(true);
        al.add(1);

        //Imprimiendo sus valores
        al.forEach(System.out::println);

        //Removiendo elementos
        al.remove(1);
        System.out.println("After removing element 1: ");
        al.forEach(System.out::println);

        //En caso que queramos remover un objeto pero no usando indices, debemos pasar ese objeto per se
        al.remove(new Integer(1));
        System.out.println("After Removing object 1");
        System.out.println("al = " + al);

        //Obteniendo objetos
        System.out.println("Usando get: " + al.get(0));

        //Supongamos que queremos guardar ese valor en una variable
        //String value = al.get(0); //Esto no se puede, dado que es de tipo Object
        // Para poder lograr esto, debemos usar Generics
        ArrayList<String> alString = new ArrayList<>(al);
        String value = alString.get(0);
        System.out.println("value from Generics ArrayList = " + value);

    }
}
