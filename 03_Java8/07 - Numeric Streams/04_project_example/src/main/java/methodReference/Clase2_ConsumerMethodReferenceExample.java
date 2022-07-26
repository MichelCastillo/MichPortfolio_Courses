package methodReference;

import data.Student;
import data.StudentDataBase;

import java.util.function.Consumer;

public class Clase2_ConsumerMethodReferenceExample {

    //Old implementation - without Method Reference
    static Consumer<Student> consumer = (student) -> System.out.println(student);

    //Method reference implementation - classname::methodName
    static Consumer<Student> consumerMethodReference = System.out::println;

    //Let's supose we want to print all activities per student
    // 1- Create a method printListOfActivities in Student class
    // 2- Create a new Consumer to use that method
    static Consumer<Student> consumerStudentMethodReference = Student::printListOfActivities;

    public static void main(String[] args) {
        //Using the old consumer implementation
        StudentDataBase.getAllStudents().forEach(consumer);

        //Using the Method Reference implementation
        StudentDataBase.getAllStudents().forEach(consumerMethodReference);

        //Using the printListOfActivities
        StudentDataBase.getAllStudents().forEach(consumerStudentMethodReference);
    }

}
