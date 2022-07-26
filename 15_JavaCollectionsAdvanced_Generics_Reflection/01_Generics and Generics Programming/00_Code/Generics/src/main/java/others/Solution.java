package others;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Solution {

    class SolutionCodility {
        public final int MAX = 0xFFFFF, MIN = 0;
        public final Pattern NUMERIC = Pattern.compile("\\d+");
        private final Stack<Integer> stack = new Stack<>();
        private final Map<String, Runnable> OPERATIONS = new HashMap<>();
        {
            OPERATIONS.put("POP", this::pop);
            OPERATIONS.put("DUP", this::dup);
            OPERATIONS.put("+", this::add);
            OPERATIONS.put("-", this::sub);
        }

        public int solution(String S) {
            // write your code in Java SE 8
            try {
                Arrays.stream(S.split(" ")).forEach(this::applyCommand);
                return pop();
            } catch (IllegalArgumentException e) {
                return -1;
            }
        }

        private void applyCommand(String s){
            if (NUMERIC.matcher(s).matches()){
                push(Integer.parseInt(s));
            } else {
                OPERATIONS.get(s).run();
            }
        }

        private void push(int i){
            withinRange(i);
            stack.push(i);
        }

        private int pop(){
            return stack.pop();
        }

        private void dup(){
            hasElements(1);
            push(stack.peek());
        }

        private void add(){
            hasElements(2);
            push(stack.pop() + stack.pop());
        }

        private void sub(){
            hasElements(2);
            push(stack.pop() - stack.pop());
        }

        private int hasElements(int i){
            if (stack.size() < i){
                throw new IllegalArgumentException("There is a few elements available");
            }
            return i;
        }

        private int withinRange(int i){
            if (i < MIN || i > MAX){
                throw new IllegalArgumentException("Input under/overflow");
            }
            return i;
        }

    }


    String str;

    private static volatile int count = 0;

    class Ota{
        String hola = str;
    }


    public static int findSmallestInterval(int[] numbers) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length -1; i++) {
            if (numbers[i + 1] - numbers[i] < diff){
                diff = numbers[i + 1] - numbers[i];
            }
        }

        return diff;
    }

    public static String isDuoDigit(int number) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");

        return "";
    }

    public static int countDigits(int number){
        if (Integer.compare(number, 0) > 0){
            return 1;
        }

        int count = 0;
        while (number != 0){
            number /= 10;
            ++count;
        }

        return count;
    }

    public static int removeRec(int number){
        int previous = number % 10;

        int n = number;
        int pow = 10;
        int res = previous;

        while (n != 0){
            int current = n % 10;

            if (current != previous){
                res += current * pow;
                previous = current;
                pow *= 10;
            }
            n /= 10;
        }

        return res;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        ArrayList l = new ArrayList(2);
        l.add(1);
        l.add(1);
        l.add(1);

        System.out.println(l.size());
    }
    // #endregion
}