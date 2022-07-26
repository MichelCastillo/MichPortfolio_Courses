package parallelStreams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class Clase01_ParallelStrams {

    public static List<String> sequentialPrintStudentActivities(){
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("SEQUENTIAL - Time: " + (System.currentTimeMillis() -  startTime));
        return studentActivities;
    }

    public static List<String> parallelPrintStudentActivities(){
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("PARALLEL - Time: " + (System.currentTimeMillis() -  startTime));
        return studentActivities;
    }

    public static void main(String[] args) {
        System.out.println(sequentialPrintStudentActivities());
        System.out.println(parallelPrintStudentActivities());
    }
}
