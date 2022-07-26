package Clase04_Wildcards;

import java.util.Arrays;

public class Excercise {

    static boolean exists(int[] ints, int k) {
        return Arrays.stream(ints).anyMatch(i -> i == k);
    }

    public static int computeClosestToZero(int[] ts) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        return Arrays.stream(ts).map(Math::abs).min().orElse(0);
    }

    public static void main(String[] args) {
        int[] ints = {-9, 14, 37, 102};
        System.out.println(exists(ints, 102)); // true
        System.out.println(exists(ints, 36)); // false
    }
}
