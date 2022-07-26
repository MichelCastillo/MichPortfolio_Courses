package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

public class Clase05_summingInt_averagingInt {

    private Student student;

    //summingInt() - this collector returns the sum as result
    public static int sum(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }


    //averagingInt() - this collector returns the sum as a result
    public static Double average(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println("Using summingInt(): " +  sum());
        System.out.println("Using averagingInt(): " +  average());
    }
}
