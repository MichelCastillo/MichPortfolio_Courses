package Clase04_Wildcards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class C03_LowerBoundedWildcards {

    /*

    We may want to use wildcards with supertypes so parent classes
    this is usually useful when we want to insert items into a generic data structure or collection
        printAll(List<? super T>)
        this method can accept a list of any superclass of T

    What if we want to add an item when using a lower bounded wildcard?
    addItem(List<? super Integer>)
        - we can add an Integer to the list without any problem
        - we can add Numbers or even Objects to the list because Number and Object are superclasses of Integer

    Principles:
        - we can not read items from List<? super T>
        - we can insert/add items into a List<? super T>
            - we can not read items form a List<? super T> because we can not guarantee what list it is really pointing to
            - we can insert subtypes of T into a List<? super T>
    */

    public static void showAll(List<? super Number> list){
        /*for (Number num:*/
        for (Object num:
             list) {
            System.out.println(num);
        }
    }
    //    Esto no es posible dado que Java no sabe que tipo puede haber, Number, Object, etc. Por lo que debemos reemplazarlo por Object

    public static void main(String[] args) {

        //Todo esto es posible dado que Number y Object son clases padre de Integer
        List<? super Integer> lInteger = new ArrayList<Integer>();
        List<? super Integer> lNumber = new ArrayList<Number>();
        List<? super Integer> lObject = new ArrayList<Object>();

        //how to read items using lower bounded wildcard
        // Implementamos la clase serializable
        List<Serializable> list = new ArrayList<>();
        list.add("Adam");
        list.add("Mich");
        list.add("Alice");
        showAll(list); //Esto es posible dado que Number implementa la clase Serializable

        //Insert items
        List<? super Number> nums = new ArrayList<>();
        nums.add(new Integer(3));
        nums.add(3);
        nums.add(3.3);
        nums.add(3.5f);

    }

}
