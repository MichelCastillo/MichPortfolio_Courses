package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> consumerStudents = (student
            -> System.out.println("Student name: " + student.getName() + ", Activities: " + student.getActivities()));
    static Consumer<Student> consumerName = (student -> System.out.println(student.getName()));
    static Consumer<Student> consumerActivities = (student -> System.out.println(student.getActivities()));

    public static void printName(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        //Antes recorreríamos cada elemento de la lista, imprimiendolo de a uno usnado un for/for each

        studentList.forEach(c2);
    }

    public static void printNameAndActivities(){
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(consumerStudents);
    }

    public static void printNameAndActivitiesANDTHEN(){
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(consumerName.andThen(consumerActivities)); //ESTE CONCEPTO SE LLAMA CONSUMER CHAIN.
    }

    public static void printNameAndActivitiesANDTHENCondition(){
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9){
                consumerName.andThen(consumerActivities).accept(student);
            }
        });
    }

    public static void main(String[] args) {

        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        //Creamos un consumidor que recibe como parámetro un objeto de tipo String, y lo pasa al cuerpo para que lo transforme a mayusculas

        //Cómo usamos esto ?
        consumer1.accept("Java 8"); //Usamos la variable que creamos, y llamamos al método acept, el cual es el que al final implementamos

        //Part 2
        printName();
        //Qué esta pasando acá?
        /*
        * 0- Creamos un consumer, que maneja objetos de tipo Student, y los imprime -> Consumer<Student>
        * 1- Creamos la lista que obtenemos desde la base de datos, y la asignamos a un objeto de tipo List<Student>
        * 2- Imprimimos a cada estudiante de la lista, pasando al forEach el consumer que creamos como parámetro.
        * */

        System.out.println("\nPRINTING NAMES AND STUDENT ACTIVITIES\n");
        printNameAndActivities();

        System.out.println("\nPRINTING NAMES AND STUDENT ACTIVITIES USING ANDTHEN\n");
        printNameAndActivitiesANDTHEN();

        System.out.println("\nPRINTING NAMES AND STUDENT ACTIVITIES USING ANDTHEN with condition\n");
        printNameAndActivitiesANDTHENCondition();

    }

}
