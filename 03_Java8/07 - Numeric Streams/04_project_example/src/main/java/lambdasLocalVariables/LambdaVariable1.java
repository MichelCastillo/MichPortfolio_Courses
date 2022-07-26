package lambdasLocalVariables;

import java.util.function.Consumer;

public class LambdaVariable1 {

    static int valueInstance = 4;

    public static void main(String[] args) {

        //FIRST RESTRICTION: Using the same variable name in lambda body or lambda expression is not allowed
        int i = 0;

        Consumer<Integer> consumer =(variable) -> { //i is not allowed, since it was initializated above

            //int i = 1; //This is isn't allowed, since i was declared above
            System.out.println("Value is: " + variable);
        };

        //SECOND RESTRICTION: Try to reassing a variable with new variable
        int value = 0;

        Consumer<Integer> consumer2 =(variable) -> {

            //int i = 1; //This is isn't allowed, since i was declared above
            System.out.println("Value is: " + value+variable);
            //value++; //It's not allowed, since this is a final variable inside the lambda scope //EFFECTIVELY FINAL concept
            valueInstance++; //it is allowed, since it's outside the method (not a local variable)
        };

        consumer2.accept(4);

    }

}
