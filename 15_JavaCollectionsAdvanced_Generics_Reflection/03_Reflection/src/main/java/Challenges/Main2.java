package Challenges;/* Happy number

    AC1: Create a method with an Integer parameter that logs true if the number is "happy" otherwise false
    AC2: A number is happy, if the sum of the squares of its digits results to be a even number

 

         GENERAL EXAMPLE:

        Input: 24

         2^2 + 4^2 = 4 + 16 = 20 (it is an even number)


         Output in the console:

            True

*/

import java.util.function.Predicate;

public class Main2 {

    public static void main(String[] args) {

        int number = 0;

        System.out.println(isHappy(number));

    }

    public static boolean isHappy(int number){
        Predicate<Integer> pred = (value) -> value % 2 == 0;

        return pred.test(getResult(number));

    }

    public static int getResult(int number){
        int res = 0;
        int n = number;

        while (n > 0){
            int digito = n % 10;
            res += digito * digito;
            n /= 10;
        }

        return res;
    }
}