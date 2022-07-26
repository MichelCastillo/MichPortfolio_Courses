package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Clase03_StreamsDebugExample {

    public static void main(String[] args) {

        //Adding more filters
        Predicate<Student> predicate = student -> student.getGpa() >= 3.0;

        Map<String, List<String>> studentMapFilter2 = StudentDataBase.getAllStudents()
                .stream().peek(student -> {
                    System.out.println("Before first filter");
                }) //Este método peek nos sirve para saber qué le estamos pasando desde el stream() al método filter()
                                                   //usa Consumer para funcionar. recibe parámetros pero no devuelve nada
                .filter(student -> student.getGradeLevel() >= 3) //Adding a predicate using lambda
                .peek(student -> {
                    System.out.println("Before 2nd filter");
                })
                .filter(predicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); //toMap receives a function - key - value

        System.out.println(studentMapFilter2);
    }

}
