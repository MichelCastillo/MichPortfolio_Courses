package defaults;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Clase01_DefultMethods {

    static Consumer<Student> studentConsumer = System.out::println;

    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName); //Ordenamos por nombre
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel); //Ordenamos por nombre


    //Opcion 1
    public static void sortByName(List<Student> studentList){
        studentList.sort(nameComparator); //Pasamos el comparator al metodo sort
        studentList.forEach(studentConsumer);
    }

    //Opcion 2 - Ordenamos por GPA ascending
    public static void sortByGpa(List<Student> studentList){
        studentList.sort(nameComparator); //Pasamos el comparator al metodo sort
        studentList.forEach(studentConsumer);
    }

    //Opcion 3 - Usamos multiples comparadores
    public static void comparatorChaining(List<Student> studentList){
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);
    }

    //Supongamos el caso en donde tenemos un null en nuestra coleccion de datos - recibimos un NullPointerException
    // Comparator -> Null first-Null last
    public static void sortWithNullValuesFirst(List<Student> studentList){
        //Usando este método, obligamos a los null a ir al principio en vez de la excepcion
        Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
        studentList.sort(studentComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortWithNullValuesLast(List<Student> studentList){
        //Usando este método, obligamos a los null a ir al principio en vez de la excepcion
        Comparator<Student> studentComparator = Comparator.nullsLast(nameComparator);
        studentList.sort(studentComparator);
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println("////////////////////BEFORE SORT");
        students.forEach(studentConsumer);

        //Queremos ordenar los Student alfabeticamente por nombre
        //System.out.println("////////////////////AFTER SORT");
        //sortByName(students);

        //Ordenando por GPA
        //System.out.println("////////////////////AFTER GPA SORT");
        //sortByGpa(students);

        //Ordenando por Grade Level y luego por Nombre
        //System.out.println("////////////////////AFTER MULTIPLE SORTS");
        //comparatorChaining(students);

        //Ordenando con nulls - nullsFirst()
        System.out.println("////////////////////AFTER NULLSFIRST COMPARATOR");
        sortWithNullValuesFirst(students);

        //Ordenando con nulls - nullsLast()
        System.out.println("////////////////////AFTER NULLSLAST COMPARATOR");
        sortWithNullValuesLast(students);
    }
}
