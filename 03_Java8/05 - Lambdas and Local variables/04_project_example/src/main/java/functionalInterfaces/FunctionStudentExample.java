package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionStudentExample {

    //Declaramos una funcion que recibe una lista de estudiantes y que devuelve un Map<String, Double
    static Function<List<Student>, Map<String, Double>> studentFunction =
            //Recorremos esa lista que nos llega como parámetro
            students -> {
                //Inicializamos el mapa que vamos a devolver
                Map<String, Double> studentGradeMap = new HashMap<>();

                //Recorremos la lista que nos llega como parámetrp
                students.forEach(student -> {
                    //Creamos un mapa con nombre - Gpa de cada estudiante
                    studentGradeMap.put(student.getName(), student.getGpa());
                });

                //Devolvemos el mapa
                return studentGradeMap;
            };

    static Predicate<Student> predicateStudent = student -> student.getGradeLevel() >= 3;

    static Function<List<Student>, Map<String, Double>> studentFunctionFilterGrade =
            students -> {
                Map<String, Double> studentGradeMap = new HashMap<>();

                students.forEach(student -> {
                    //Aplicamos el predicado para filtrar por grado
                    if (predicateStudent.test(student)) {
                        studentGradeMap.put(student.getName(), student.getGpa());
                    }
                });

                return studentGradeMap;
            };

    public static void main(String[] args) {

        //Imprimimos el mapa generado
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));

        //Supongamos que tenemos una nueva regla de negocio que nos pide crear ese mapa solo para los alumnos que sean mayores a 3er grado
        System.out.println(studentFunctionFilterGrade.apply(StudentDataBase.getAllStudents()));


    }

}
