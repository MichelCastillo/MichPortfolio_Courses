package constructorReference;

import data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    //To get this working, we need to have an empty constructor in the Student class
    static Supplier<Student> studentSupplier = Student::new;

    //Creating a function that is gonna accept a String
    // Este método nos obliga a crear un constructor que reciba un String como parámetro (input de la function)
    static Function<String, Student> studentFunction = Student::new;


    public static void main(String[] args) {

        //Using supplier implementation (empty constructor)
        System.out.println(studentSupplier.get());

        //Using function implementation - Constructor with string parameter
        System.out.println(studentFunction.apply("Mich"));

    }
}
