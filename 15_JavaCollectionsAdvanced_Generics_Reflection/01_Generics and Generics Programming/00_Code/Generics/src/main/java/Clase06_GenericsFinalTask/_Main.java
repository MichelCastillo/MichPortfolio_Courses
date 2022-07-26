package Clase06_GenericsFinalTask;

public class _Main {

    public static void main(String[] args) {
        Library<Algorithm> library = new Library<Algorithm>();

        library.add(new SearchAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new GraphAlgorithm());

        Algorithm item = library.getLast();

        while (item != null){
            item.execute();
            item = library.getLast();
        }
    }

}
