package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Clase06_groupingBy {

    //groupingBy() collector is equivalent to the groupBy() operation in SQL
    // - Used to group the elements based on a property
    // - The output of the groupingBy() is Map<K,V>

    //Agrupamos a los alumnos en base a su genero
    //  - Version 1: groupingBy(classifier):
    public static Map<String, List<Student>> groupStudentsByGender1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
    }

    //Categorizando a alumnos en base a sus notas
    public static Map<String, List<Student>> customizedGroupingByGpa(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(
                                student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"
                        )
                );
    }

    //  - Version 2: groupingBy(classifier, downstream):  //El downstream es como un segundo groupby
    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, //Este es el integer del mapa principal
                        groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"))); //Este es el Key del mapa secundario
    }

    //En este caso, vamos a sumar por agrupamientos
    public static Map<Integer, Integer> twoLevelGrouping_2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, //Este es el integer del mapa principal
                        summingInt(Student::getNoteBooks))); //Con esto sumamos la cantidad de notebooks por grado
    }

    public static Map<String, Long> exercise() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(
                        groupingBy(a -> a, counting())
                );
    }

    //  - Version 3: groupingBy(classifier,supplier,downstream):
    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupBy(){
        return  StudentDataBase.getAllStudents().stream()
                .collect(
                        groupingBy(
                                Student::getName, LinkedHashMap::new, toSet() //Esto va a devolver un LinkedHashMap, desde el segundo argumento, cuyas claves van a ser los
                                                                                // nombres de los alumnos junto con un set de estudiantes como valores
                        )
                );
    }

    public static void main(String[] args) {
        System.out.println("VERSION_1: " + groupStudentsByGender1());
        System.out.println("VERSION_1_CUSTOMIZED: " +customizedGroupingByGpa());

        System.out.println("VERSION_2: " + twoLevelGrouping_1());
        System.out.println("VERSION_2_SUMMINGINT: " + twoLevelGrouping_2());

        System.out.println(exercise());
        System.out.println(threeArgumentGroupBy());
    }
}
