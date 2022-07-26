package defaults;

import java.util.Arrays;
import java.util.List;

public class Clase02_MultiplierClient {

    public static void main(String[] args) {
        //Prior Java 8
        Clase02_Multiplier multiplier = new Clase02_MultiplierImpl();

        List<Integer> integerList = Arrays.asList(1,3,5);
        System.out.println("Result is: " +  multiplier.multiply(integerList));

        //Java 8 - default method
        System.out.println("Default method size is: " + multiplier.size(integerList));

        //Java 8 - static method
        System.out.println("Static method isEmpty() is: " + Clase02_Multiplier.isEmpty(integerList));
    }
}
