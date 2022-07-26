package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import static java.util.stream.Collectors.*;

public class Clase08_Filter {

    //Concepto: filter: se usa para filtrar elemenos en un stream
    // la entrada de un filtro es un Predicate Functional Interface

    //Devolvemos una lista de Student siempre y cuando sean mujeres
    public static List<Student> filterFemaleStudents(){
        return StudentDataBase.getAllStudents().stream()
                .filter((student) -> student.getGender().equals("female"))
                .collect(toList());
    }

    //Devolvemos una lista de Student de mujeres con un gpa >= 3.0
    public static List<Student> filterFemaleStudentsGpa(){
        return StudentDataBase.getAllStudents().stream()
                .filter((student) -> student.getGender().equals("female"))
                .filter(student -> student.getGpa() >= 3.0)
                .collect(toList());
    }


    public static void main(String[] args) {

        filterFemaleStudents().forEach(System.out::println);
    }
}
