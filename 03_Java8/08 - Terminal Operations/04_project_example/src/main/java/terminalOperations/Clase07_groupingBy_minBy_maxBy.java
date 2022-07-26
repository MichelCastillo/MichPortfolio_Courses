package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Clase07_groupingBy_minBy_maxBy {
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

    //Vamos a calcular el máximo Student GPA por GRADO
    //TOP GPA STUDENT
    public static Map<Integer, Optional<Student>> calculateTopGpa(){
        return StudentDataBase.getAllStudents().stream()
                .collect(
                        groupingBy(
                                Student::getGradeLevel, maxBy(
                                        Comparator.comparing(Student::getGpa)
                                )
                        )
                );
    }

    //TOP GPA STUDENT WITHOUT OPTIONAL
    public static Map<Integer, Student> calculateTopGpaWithoutOptional(){
        return StudentDataBase.getAllStudents().stream()
                .collect(
                        groupingBy(
                                Student::getGradeLevel, collectingAndThen(
                                        maxBy(
                                                Comparator.comparing(Student::getGpa)
                                        ), Optional::get
                                )
                        )
                );
    }

    //LAST GPA STUDENT WITHOUT OPTIONAL
    public static Map<Integer, Student> calculateLastGpaWithoutOptional(){
        return StudentDataBase.getAllStudents().stream()
                .collect(
                        groupingBy(
                                Student::getGradeLevel, collectingAndThen(
                                        minBy(
                                                Comparator.comparing(Student::getGpa)
                                        ), Optional::get
                                )
                        )
                );
    }

    public static void main(String[] args) {

        //TOP GPA STUDENT
        System.out.println("TOP GPA STUDENT PER GRADE");
        System.out.println(calculateTopGpa());
        System.out.println(calculateTopGpaWithoutOptional());

        //LAST GPA STUDENT
        System.out.println("LAST GPA STUDENT PER GRADE");
        System.out.println(calculateLastGpaWithoutOptional());

    }
}

