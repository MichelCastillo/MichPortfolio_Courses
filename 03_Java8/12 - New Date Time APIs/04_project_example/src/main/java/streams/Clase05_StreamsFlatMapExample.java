package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class Clase05_StreamsFlatMapExample {

    //Concepto: convierte un tipo a otro como map().
    // Por lo general se usa en contexto Stream donde cada elemento representa multiples elementos
    // Ejemplo: Stream<List> - Stream<Arrays>

    //Queremos mostrar las actividades de todos los estudiantes en una lista
    public static List<String> printStudentActivities(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)//Stream<List<String>> -> no podemos usar Collectors.toList(), dado que espera un Stream<String>
                .flatMap(List::stream)//Con esto transformamos de Stream<List<String>> a  Stream<String>
                .collect(Collectors.toList());
    }

    public static long getStudentActicitiesCount(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        System.out.println(printStudentActivities());
    }

}
