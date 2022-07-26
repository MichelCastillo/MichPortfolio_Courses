package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Clase01_StreamsExample {

    public static void main(String[] args) {

        //Student name and there list of activities in a Map

        //Getting all students
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
                .stream()//Starting stream
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //toMap receives a function - key - value

        System.out.println(studentMap);

        //Filtering that list
        Map<String, List<String>> studentMapFilter = StudentDataBase.getAllStudents()
                .stream()//Starting stream
                .filter(student -> student.getGradeLevel() >= 3) //Adding a predicate using lambda
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //toMap receives a function - key - value

        System.out.println("FILTERED MAP OF STUDENTS");
        System.out.println(studentMapFilter);

        //Adding more filters
        Predicate<Student> predicate = student -> student.getGpa() >= 3.0;

        Map<String, List<String>> studentMapFilter2 = StudentDataBase.getAllStudents()
                .parallelStream()//Starting stream - is the same than stream, but running in parallel threads
                .filter(student -> student.getGradeLevel() >= 3) //Adding a predicate using lambda
                .filter(predicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //toMap receives a function - key - value

        System.out.println("ADDING A NEW FILTER TO THE MAP");
        System.out.println(studentMapFilter2);
    }

}
