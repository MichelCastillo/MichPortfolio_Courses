package functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> isEvenInteger = integer -> integer % 2 == 0;
    static Predicate<Integer> isDivisibleBy5 = integer -> integer % 2 == 0;

    public static void predicateAnd(Integer number){
        System.out.println(isEvenInteger.and(isDivisibleBy5).test(number));
    }

    public static void predicateOr(Integer number){
        System.out.println(isEvenInteger.or(isDivisibleBy5).test(number));
    }

    public static void predicateNegate(Integer number){
        System.out.println(isEvenInteger.or(isDivisibleBy5).negate().test(number));
    }

    public static void main(String[] args) {

        //Creating a Predicate
        Predicate<Integer> predicateInteger
                = (i) -> {return i % 2 ==0;}; //Preguntamos si el entero que pasamos es par

        System.out.println(predicateInteger.test(4));

        //Simplified way
        Predicate<Integer> predicateIntegerSimplified = i -> i % 2 == 0;

        System.out.println(predicateIntegerSimplified.test(4));

        //Using the rest of the methods of that interface, and, or, negate
        //Using AND
        predicateAnd(10);

        //Using OR
        predicateOr(8);

        //Using negate -> devuelve el resultado contrario
        predicateNegate(9);

    }

}
