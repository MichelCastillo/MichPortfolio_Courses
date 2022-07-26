package Clase05_SortingCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class C01_SortingArrays {

    public static void main(String[] args) {

        // Quicksort - to sort primitive types (int, float, etc)
        int[] nums = {1, 10, 5, 2, -5, 12, 14, 0, 1 , 2};

        // Arrays.sort(nums, Collections.reverseOrder());
        Arrays.sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

        String[] names = {"Adam", "Kevin", "Daniel", "Ana", "Joel"};
        Arrays.sort(names);

        for (String name : names) {
            System.out.print(name + " ");
        }

        // Mergesort - to sort reference types (Integer, String, etc)



    }
}
