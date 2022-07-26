package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class Clase00_Introduction {

    //This was introduced as part of Java 8 to represent a Non-Null value
    //Avoids Null Pointer Exception and Unnecesarry Null Checks
    //Inspired from the new lenguages such as scala, groovy, etc.

    //Caso de uso: Vamos a crear un método que nos devuelva un String por el nombre de el alumno y vamos a devolver la longitud de tal nombre
    public static String getStudentName(){
        //Student student = StudentDataBase.studentSupplier.get();
        Student student = null;

        //Si el estudiante es null
        if (student != null){
            return student.getName();
        }

        return null;
    }

    //Mismo método pero usando Optional
    public static Optional<String> getStudentNameOptional(){
        //Existen varias formas de usar Optional
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Con esta forma estamos haciendo wrapping de un Student dentro de Optional

        if (studentOptional.isPresent()){
            return studentOptional.map(Student::getName); //Optional<String>
        }

        return Optional.empty(); //Represents an optional object with no value

    }

    public static void main(String[] args) {
        //Probamos el método
        //En caso de que el alumno no existiera o apsara algo y recibieramos null, obtendriamos un nullPointerException
        // Con este esquema tenemos multiples null checks

        String name = getStudentName();
        if (name != null){
            System.out.println("Length of the Student Name: " + name.length());
        } else {
            System.out.println("Name not found.");
        }

        //Mismo escenario pero usando Optional
        Optional<String> stringOptional = getStudentNameOptional();
        if (stringOptional.isPresent()){
            System.out.println("Optional length name: " + stringOptional.get().length());
        } else {
            System.out.println("Optional Name not found.");
        }



    }
}
