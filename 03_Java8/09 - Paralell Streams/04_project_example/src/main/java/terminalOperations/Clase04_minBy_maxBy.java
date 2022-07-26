package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Clase04_minBy_maxBy {

    //Ambos reciben un Comparator como entrada y devuelven un Optional

    //minBy
    //This collector is used in conjuction with comparator. Returns the smallest element based on the property passed to the comparator.
    public static Optional<Student> minByCustom(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.minBy(
                                Comparator.comparing(Student::getGpa) //Esto va a devolver el estudiante con el menor Gpa
                        )
                );
    }

    //maxBy
    //this collector is used in conjuction with comparator. Returns the max element based on the property passed to the comparator
    public static Optional<Student> maxByCustom(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.maxBy(
                                Comparator.comparing(Student::getGpa) //Esto va a devolver el estudiante con el menor Gpa
                        )
                );
    }

    public static void main(String[] args) {
        minByCustom().ifPresent(student -> System.out.println("El estudiante con menor GPA es: " + student));
        maxByCustom().ifPresent(student -> System.out.println("El estudiante con mayor GPA es: " + student));
    }
}
