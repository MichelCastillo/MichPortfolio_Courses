package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Clase03_mapping {

    //mapping() - applies a transformation function first and then collect the data in a collection (could be any type of collection)

    public static void main(String[] args) {
        List<String> nameList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName, toList())); //Esto va a colectar una lista de nombre de estudiantes

        System.out.println("Name list: " + nameList);

        Set<String> nameSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName, toSet())); //Esto va a colectar un set de nombre de estudiantes

        System.out.println("Name set: " + nameSet);

        //Con esta forma podemos ahorrarnos un paso con esta forma:
        /*StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(toList());*/

    }


}
