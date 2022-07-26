package functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    //Creating a comparator
    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {
        //En este caso, esto recibe dos parametros del mismo tipo y devuelve 1 del mismo tipo
        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

        System.out.println(binaryOperator.apply(3, 4));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Result of maxBy operator: " + maxBy.apply(4,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Result of maxBy operator: " + minBy.apply(4,5));
    }

}
