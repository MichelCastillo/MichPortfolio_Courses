package streams;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Clase09_Reduce {

    //Concepto: esta es una operacion terminal. Usada para reducir el contenido de un stream a un solo valor
    // Toma dos valores como entradas:
    // First parameters: valor por default o valor inicial
    // Second Parameter: BinaryOperator<T>

    //Devolvemos el resultado de la multiplicacion de toda la lista que pasamos por parametro
    public static int performMultiplication(List<Integer> integerList){
        return integerList.stream()
                //1
                //3
                //5
                //7
                //1st iteration: a=1 (initial value), b=1 (from stream) -> result: 1 is returned
                //2nd iteration: a=1 (from result of 1st iteration), b=3 -> result: 3 is returned
                //3rd iteration: a=3, b=5 -> result: 15
                //4th iteration: a=15, b=7 -> result:105
                .reduce(1, (a,b) -> a*b);
    }

    //Variacion donde no pasamos el initial value
    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList){
        //Con esta variación, debemos devolver un Optional, con el cual vamos a poder manejar los valores null
        return integerList.stream()
                .reduce((a,b) -> a*b);
    }

    //Vamos a reducir la coleccion para que nos devuelva el alumno con mayor GPA
    public static Optional<Student> getHighestGpaStudent(){
         return StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }

    public static void main(String[] args) {

        //Declaramos una lista de enteros
        List<Integer> integers = Arrays.asList(1,3,5,7);
        List<Integer> integers1 = new ArrayList<>();

        //Showing the result
        System.out.println(performMultiplication(integers));

        //Using Optional implementation
        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());

        //Using Optional Implementation with empty list
        Optional<Integer> result1 = performMultiplicationWithoutIdentity(integers1);
        System.out.println(result1.isPresent());

        result1.ifPresent(System.out::println);

        //Devolviendo el Student con el GPA mas grande
        Optional<Student> studentOptional = getHighestGpaStudent();
        studentOptional.ifPresent(System.out::println);
    }
}
