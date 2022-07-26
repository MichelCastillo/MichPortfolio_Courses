package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiCoonsumerExample {

    public static void printNameAndActivities(){
        //Implementación del método que hicimos en la clase ConsumerExample, con 2 consumer separados
        BiConsumer<String, List<String>> biConsumer
                = (name, activities) -> System.out.println(name + " : " + activities);

        List<Student> students = StudentDataBase.getAllStudents();

        students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {

        //Concatenating strings with BiConsumer
        BiConsumer<String,String> biConsumer = (a,b) -> {
            System.out.println("a: " + a + ", b: " + b);
        };

        biConsumer.accept("Java 7", "Java 8");

        //Operation with integers using BiConsumer
        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("Multiplication is: " + (a*b));
        };

        BiConsumer<Integer, Integer> division = (a,b) -> {
            System.out.println("Division is: " + (a/b));
        };

        multiply.andThen(division).accept(10, 5);

        //Running BiConsumer method
        printNameAndActivities();
    }

}
