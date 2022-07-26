package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clase07_StreamComparatorExample {

    //Caso de uso: imprimir una lista ordenada alfabeticamente de nombres de estudiantes
    public static List<Student> getSortStudentListByName(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    //Ordenamos mediante GPA
    public static List<Student> getSortStudentListByGpa(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    //Ordenamos mediante GPA invertido
    public static List<Student> getSortStudentListByGpaDesc(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //List of students sorted by name
        System.out.println(getSortStudentListByName());

        //List of students sorted by gpa
        System.out.println(getSortStudentListByGpa());

        //List of students sorted by gpa desc
        System.out.println(getSortStudentListByGpaDesc());
    }

}

