package methodReference;

import java.util.function.Function;

public class Clase1_FunctionMethodReferenceExample {

    //Input String, Output String
    static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();

    //Implementation using Method Reference
    static Function<String, String> toUpperCaseMethod = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("java8"));

        System.out.println(toUpperCaseMethod.apply("java8 method reference"));
    }

}
