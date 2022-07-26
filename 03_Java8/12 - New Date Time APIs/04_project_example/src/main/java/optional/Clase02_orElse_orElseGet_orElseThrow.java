package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class Clase02_orElse_orElseGet_orElseThrow {

    //orElse - Este método sirve para devolver un valor por defecto en caso de que el valor que queremos nos devuelva un null
    public static String optionalOrElse(){
        Optional<Student> optionalStudent
                //= Optional.ofNullable(null);
                = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        return optionalStudent.map(Student::getName)
                .orElse("Default");
    }

    //orElseGet - Este metodo a diferencia del orElse, recibe como parametro un Supplier(sin parametros de entrada pero si devuelve algo)
    // en este caso, usamos una expresion lambda para el supplier
    public static String optionalOrElseGet(){
        Optional<Student> optionalStudent
                //= Optional.ofNullable(null);
                = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        return optionalStudent.map(Student::getName)
                .orElseGet(() -> "Default");
    }

    //orElseThrow - este método lanzará una RuntimeException en caso de que el nombre sea null
    public static String optionalOrElseThrow(){
        Optional<Student> optionalStudent
                //= Optional.ofNullable(null);
                = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        return optionalStudent.map(Student::getName)
                .orElseThrow(() -> new RuntimeException("No data available"));
    }

    public static void main(String[] args) {
        System.out.println("orElse(): "+ optionalOrElse());
        System.out.println("orElseGet(): "+ optionalOrElseGet());
        System.out.println("orElseThrow(): "+ optionalOrElseThrow());
    }
}
