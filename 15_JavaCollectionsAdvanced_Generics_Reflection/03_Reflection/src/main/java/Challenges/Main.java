package Challenges;/*

    Given an array of integers, find if the array contains some duplicates.
    Your function should return an array with all numbers that duplicates in the array, return an
    empty array if every element is distinct.

    Example 1:

    Input: [1,2,3,1]

    Output: [1]

    Example 2:

    Input: [1,2,3,4]

    Output: []



    Example 3:

    Input: [1,9,7,1,3,3,4,3,7,2,4,2,6,5]

    Output: [1,3,7,4,2]

*/


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Example 1 ---");

        int[] ex1 = {1,2,3,1};

        System.out.println("Expected: [1]");

        System.out.println("Result  : " + java.util.Arrays.toString(containsDuplicate(ex1)));



        System.out.println("--- Example 2 ---");

        int[] ex2 = {1,2,3,4};

        System.out.println("Expected: []");

        System.out.println("Result: " + java.util.Arrays.toString(containsDuplicate(ex2)));



        System.out.println("--- Example 3 ---");

        int[] ex3 = {1,9,7,1,3,3,4,3,7,2,4,2,6,5};

        System.out.println("Expected: [1,3,7,4,2]");

        System.out.println("Result: " + java.util.Arrays.toString(containsDuplicate(ex3)));

    }



    public static int[] containsDuplicate(int[] numbers)

    {
        Set<Integer> setResult = new LinkedHashSet<>();
        Set<Integer> compareSet = new LinkedHashSet<>();

        for (int number : numbers) {
            if (!compareSet.add(number)){
                setResult.add(number);
            }
        }

        return setResult.stream().mapToInt(i -> i).toArray();

    }

}