package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Clase11_MinMax {

    public static int findMaxValue(List<Integer> integerList){
        return integerList.stream()
                .reduce(Integer.MIN_VALUE, (x,y) -> x > y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce((x,y) -> x > y ? x : y);
    }

    public static int findMinValue(List<Integer> integerList){
        return integerList.stream()
                .reduce(Integer.MIN_VALUE, (x,y) -> x < y ? x : y);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList){
        return integerList.stream()
                .reduce((x,y) -> x < y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        System.out.println("////////////////////////////////////////////MAX_VALUE");

        //Getting the max element of the list
        System.out.println("MAX_VALUE: " +  findMaxValue(integers));

        //Using an empty LIST
        List<Integer> emptyIntegers = new ArrayList<>();
        //System.out.println("MAX_VALUE_EMPTY_LIST: " + findMaxValue(emptyIntegers));
        //Esta es la razón por la que no deberiamos asignar ningun valor por defecto a las comparaciones

        //Using an empty list with Optional
        Optional<Integer> maxValueOptional = findMaxValueOptional(emptyIntegers);
        if (maxValueOptional.isPresent()){
            System.out.println("MAX_VALUE_OPTIONAL: " +  maxValueOptional);
        } else {
            System.out.println("Input list is empty.");
        }

        System.out.println("////////////////////////////////////////////MIN_VALUE");
        int minValue = findMinValue(integers);
        System.out.println("MIN_VALUE: " + minValue);

        //Using Optional
        Optional<Integer> minValueOptional = findMinValueOptional(integers);
        if (minValueOptional.isPresent()){
            System.out.println("MIN_VALUE_OPTIONAL: " +  minValueOptional.get());
        } else {
            System.out.println("Input list is empty.");
        }

    }
}
