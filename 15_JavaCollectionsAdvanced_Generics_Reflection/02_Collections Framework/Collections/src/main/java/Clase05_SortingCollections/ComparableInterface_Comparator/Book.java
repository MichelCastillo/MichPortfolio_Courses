package Clase05_SortingCollections.ComparableInterface_Comparator;

public class Book {
        /*implements Comparable<Book>{*/

    private String authorName;
    private String title;
    private int numPages;

    public Book() {
    }

    public Book(String authorName, String title, int numPages) {
        this.authorName = authorName;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", numPages=" + numPages +
                '}';
    }

    /*@Override
    public int compareTo(Book o) {
        *//*if (this.numPages > o.getNumPages()) {
            return 1;
        }

        if (this.numPages == o.getNumPages())
            return 0;

        return -1; -> NOT FORCED REVERSE ORDER*//*

        return this.authorName.compareTo(o.getAuthorName());
        // Comparing using number of pages
        *//* return Integer.compare(this.numPages, o.getNumPages());*//*
        *//* return -Integer.compare(this.numPages, o.getNumPages()); -> FORCED REVERSE ORDER*//*
    }*/
}
