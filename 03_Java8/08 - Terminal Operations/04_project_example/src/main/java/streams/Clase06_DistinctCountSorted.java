package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Clase06_DistinctCountSorted {

    //Concepto:
    // distinct(): devuelve un stream con elementos unicos (sin repetir)
    // count(): devuelve un long con el total de elementos en un stream
    // ordena los elementos en un stream

    //Distinct
    public static List<String> getStudentActivitiesDistinct(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //Sacando los repetidos
                .collect(Collectors.toList());
    }

    //Count
    public static long getStudentActivitiesCount(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //Stream<String>
                .count();
    }

    //Sorted
    public static List<String> getStudentActivitiesDistinctSorted(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() //Sacando los repetidos
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> getMapActivityCount(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(activity -> activity, Collectors.counting()));
    }

    public static void main(String[] args) {

        //Distinct
        System.out.println(getStudentActivitiesDistinct());

        //Count
        System.out.println(getStudentActivitiesCount());

        //Sorted
        System.out.println(getStudentActivitiesDistinctSorted());

        //Mapa con la cantidad de apariciones de cada deporte
        System.out.println(getMapActivityCount());
    }
}
