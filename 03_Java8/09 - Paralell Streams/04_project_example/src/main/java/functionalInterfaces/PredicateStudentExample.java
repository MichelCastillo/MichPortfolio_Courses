package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> predicateGradeLevel = student -> student.getGradeLevel() >= 3;

    static Predicate<Student> predicateGpa = student -> student.getGpa() >= 3.9;

    public static void filterStudentByGradeLevel(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if (predicateGradeLevel.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudentByGpa(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if (predicateGpa.test(student)){
                System.out.println(student);
            }
        });
    }

    //Combinando ambos predicados
    public static void filterStudentByBothFilters(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if (predicateGradeLevel.and(predicateGpa).test(student)){
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("///////////////////////////////// GRADE LEVEL");

        filterStudentByGradeLevel();

        System.out.println("///////////////////////////////// GPA");
        filterStudentByGpa();

        System.out.println("///////////////////////////////// BOTH FILTERS");
        filterStudentByBothFilters();

    }

}
