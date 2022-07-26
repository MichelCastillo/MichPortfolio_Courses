package Clase04_Wildcards;

import Clase04_Wildcards.C01_shapes_example.Rectangle;
import Clase04_Wildcards.C01_shapes_example.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_UpperBoundedWildcards {

    /*Notas:
    we may want to use wildcars with subtypes so child classes
    for example, we want to show the items in a List<Rectangle> when the Rectangle is a Shape
        printAll(List<? extends T>) -> this method can accept a list of anny subclass of T

    Principle: we can read items for a List<? extends T>

    - What if we want to add an item when using an upper bounded wildcard?
        addItem(List<extends Number>)
            - we can NOT add an INteger to the list because the type can noy be guaranteed - it may be a List<Double>
            - we can NOT add a Double to the list because the type can not be guaranteed - it may be a List<Integer>
    Principle: we CAN NOT add item to a List<? extends T> because you can not guarantee what list it is really pointing to.

    If we want to:
        - Read values: use upper bounded wildcards
        - Manipulate values: use lower bounded wildcards

    */

    public static void drawAll(List<? extends Shape> shapes){
        shapes.forEach(System.out::println);
    }

    public static void showAll(List<? extends Number> list){
        list.forEach(System.out::println);
    }

    public static double sumAll(List<? extends Number> numbers){
        double result = (double) 0;
        for (Number number:
             numbers) {
            result += number.doubleValue();
        }
        return result;
    }

    public static void main(String[] args) {
        List<? extends Number> l1 = new ArrayList<Integer>();
        /*l1.add(new Integer(23)); //Esto no funciona dado que Java no puede inferir el tipo de la lista*/
        List<? extends Number> l2 = new ArrayList<Double>();
        List<? extends Number> l3 = new ArrayList<Float>();
        /*List<? extends Number> lString = new ArrayList<String>();//No funciona dado que String no extiende de Number*/

        //showAll(Arrays.asList(1, 2, 3)); // Se imprimen enteros
        //showAll(Arrays.asList(1.3, 2.5, 3)); // se imprimen flotantes
        System.out.println(sumAll(Arrays.asList(1.3, 2.5, 3)));



    }

}
