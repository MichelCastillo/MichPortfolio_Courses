package data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDataBase {

    //Creamos un método que nos devuelva solo un estudiante
    public static Supplier<Student> studentSupplier = () -> {
        return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "bastketball", "volleyball"));
    };

    public static List<Student> getAllStudents(){

        //2nd grade students
        Student student1 = new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "bastketball", "volleyball"));
        Student student2 = new Student("Jenny", 2, 3.8, "female", Arrays.asList("swimming", "gymnastics", "soccer"));

        //3rd grade students
        Student student3 = new Student("Emily", 3, 4.0, "female", Arrays.asList("swimming", "gymnastics", "soccer"));
        Student student4 = new Student("Dave", 3, 3.9, "female", Arrays.asList("swimming", "gymnastics", "soccer"));

        //4th grade students
        Student student5 = new Student("Sophia", 4, 3.8, "female", Arrays.asList("swimming", "gymnastics", "soccer"));
        Student student6 = new Student("James", 4, 3.8, "female", Arrays.asList("swimming", "gymnastics", "soccer"));

        return Arrays.asList(student1, student2, student3, student4, student5, student6);
    }
}
