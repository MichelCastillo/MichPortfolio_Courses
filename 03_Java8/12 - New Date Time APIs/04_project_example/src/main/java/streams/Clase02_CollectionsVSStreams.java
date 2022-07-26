package streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Clase02_CollectionsVSStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        //Adding elements to array
        names.add("Mich");
        names.add("Michel");
        names.add("Michell");

        //Removinv methods in the array
        names.remove(0);

        //Getting elements from the array.
        String nameFromArray = names.get(0);

        //aWay to iterate the list
        for (String name: names
             ) {
            System.out.println(name);
        }

        //In the streams, it's not possible to add or remove elements
        //elements in streams, can be accessed only in sequence and not for indexes.

        //Iterating the stream
        Stream<String> nameStream = names.stream(); //We can iterate a stream only 1 time.
        nameStream.forEach(System.out::println);

    }
}
