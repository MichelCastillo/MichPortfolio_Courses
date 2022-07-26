package Clase05_SortingCollections.ComparableInterface_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Mich", "Mich", 100));
        bookList.add(new Book("Mich2", "Mich22", 1020));
        bookList.add(new Book("Mich3", "Mich33", 1022));
        bookList.add(new Book("Mich4", "Mich44", 1330));
        bookList.add(new Book("Mich5", "Mich55", 1200));

        // Sorting collection -> Debemos especificar con qué campo vamos a ordenar
        // Ya implementamos Comparable<Book> en la clase book, y le dijimos que lo haga por el nombre del autor
        // Collections.sort(bookList);
        Collections.sort(bookList, new BookComparator());

        System.out.println(bookList);


    }
}
