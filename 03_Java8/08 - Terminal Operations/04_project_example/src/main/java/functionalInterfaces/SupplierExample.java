package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    //A diferencia de on Consumer, que recibe parámetros pero no devuelve nada
    //EL supplier no recibe parametros pero devuelve algo

    public static void main(String[] args) {

        Supplier<Student> studentSupplier = () -> {
            return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "bastketball", "volleyball"));
        };

        System.out.println("Student is: " + studentSupplier.get());

        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println("List of suppliers: " + listSupplier.get());
    }

}
