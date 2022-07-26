package Clase02_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C05_SortingUsingLambdas {

    // Como vamos a usar Lambdas, no hace falta implementar la clase Comparable en PersonLambda

    public static void main(String[] args) {

        List<PersonLambda> people = new ArrayList<>();

        people.add(new PersonLambda("Adam", 33));
        people.add(new PersonLambda("Adam1", 23));
        people.add(new PersonLambda("Adam2", 43));
        people.add(new PersonLambda("Adam3", 21));
        people.add(new PersonLambda("Adam4", 42));

        //Comparando usando lambdas
        Collections.sort(people, Comparator.comparing(PersonLambda::getAge));

        // Reversed
        Collections.sort(people, Comparator.comparing(PersonLambda::getAge).reversed());

        // Multiple Criteria
        Collections.sort(people, Comparator.comparing(PersonLambda::getAge).thenComparing(PersonLambda::getName));

        for (PersonLambda person : people) {
            System.out.println(person.getName() + " - Age: " + person.getAge());
        }
    }

}
