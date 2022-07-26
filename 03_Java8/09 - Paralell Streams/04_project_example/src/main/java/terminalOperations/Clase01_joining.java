package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Clase01_joining {

    //Terminal operations collects data for us and starts the whole stream pipeline
    // i.e. : forEach, min, max, reduce, collect, etc
    //We are focusing on:
    //collect() - takes in an input of type Collector and produces the result as per the input passed to the collect() method

    // - joining() - Collector performs the String concatenation on the elements in the stream. Has 3 different versions

    //Queremos concatenar los nombres de todos los estudiantes
    public static String joining_1(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) //Stream<String>
                .collect(joining());
    }

    public static String joining_2(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) //Stream<String>
                .collect(joining("-")); //Adding a delimitier between each every value
    }

    public static String joining_3(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) //Stream<String>
                .collect(joining("-", "(", ")")); //Adding a delimitier between each every value, and a prefix and sufix
    }

    public static void main(String[] args) {
        System.out.println("Joining_1: " + joining_1());

        System.out.println("Joining_2: " + joining_2());

        System.out.println("Joining_3: " + joining_3());
    }

}
