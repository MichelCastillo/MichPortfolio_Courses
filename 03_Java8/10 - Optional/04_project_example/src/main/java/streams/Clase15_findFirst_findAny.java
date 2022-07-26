package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class Clase15_findFirst_findAny {

    //Used to find an element in the stream. In this case, these methods retrive an element itself instead of boolean as anyMatch
    //Both functions returns the result of type Optional

    //findFirst() - returns first element in the stream
    public static Optional<Student> findFirstStudent(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }

    //findAny() - returns the first encountered element in the stream
    public static Optional<Student> findAnyStudent(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny(); //Por este findAny, aplica el filtro a todos los elementos hasta que encuentra uno, luego ignora el resto
    }

    //La direfencia de estos métodos aparece cuando ejecutamos esto en parallel streams.

    public static void main(String[] args) {

        Optional<Student> studentOptionalFindAny = findAnyStudent();
        studentOptionalFindAny.ifPresent(student -> System.out.println("Found the student findAny " + student));

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        studentOptionalFindFirst.ifPresent(student -> System.out.println("Found the student findFirst: " + student));

    }
}
