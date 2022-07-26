package methodReference;

import data.Student;
import data.StudentDataBase;

import java.util.function.Predicate;

public class Clase3_RefactorMethodReferenceExample {

    //Old implementation of this student predicate
    static Predicate<Student> predicateGradeLevel = student -> student.getGradeLevel() >= 3;

    //Method reference implementation
    //Creamos un método con la misma funcionalidad del predicado
    public static boolean greaterThanGradeLevel(Student s){
        return s.getGradeLevel() >= 3;
    }

    //Creamos una variable usando el metodo estatico de esta clase estatica
    static Predicate<Student> predicateMethodReference = Clase3_RefactorMethodReferenceExample::greaterThanGradeLevel;

    public static void main(String[] args) {

        System.out.println(predicateGradeLevel.test(StudentDataBase.studentSupplier.get()));

        //Using the new Predicate
        System.out.println(predicateMethodReference.test(StudentDataBase.studentSupplier.get()));

    }
}
