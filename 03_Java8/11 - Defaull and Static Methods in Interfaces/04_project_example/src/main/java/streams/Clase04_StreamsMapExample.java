package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Clase04_StreamsMapExample {

    //map: sirve para convertir un tipo en otro, por ejemplo, acá vamos a transformar una lista de Student en una lista de String

    //Use case: select all of the students in a list, and print them in the console
    //1 - Create a method
    public static List<String> nameList(){
        return StudentDataBase.getAllStudents().stream()
                //Con esto estamos diciendo: INPUT: STUDENT -> OUTPUT: STUDENT_NAME(STRING)
                .map(Student::getName) // lo mismo que : static Function<Student, String> functionStudent = Student::getName
                //Podemos agregar operaciones sobre la lista que obtuvimos
                .map(String::toUpperCase) //En este caso, los ponemos en mayusculas
                .collect(Collectors.toList());
    }

    //Supongamos que en vez de una lista, queramos un set
    public static Set<String> nameSet(){
        return StudentDataBase.getAllStudents().stream()
                //Con esto estamos diciendo: INPUT: STUDENT -> OUTPUT: STUDENT_NAME(STRING)
                .map(Student::getName) // lo mismo que : static Function<Student, String> functionStudent = Student::getName
                //Podemos agregar operaciones sobre la lista que obtuvimos
                .map(String::toUpperCase) //En este caso, los ponemos en mayusculas
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        //2- Printing the list of names
        System.out.println(nameList());
    }

}
