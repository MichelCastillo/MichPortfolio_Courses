package Clase05_SortingCollections.ComparableInterface_Comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getNumPages(), b2.getNumPages());

        //Sorting using author name
        /*return b1.getAuthorName().compareTo(b2.getAuthorName());*/
    }
}
