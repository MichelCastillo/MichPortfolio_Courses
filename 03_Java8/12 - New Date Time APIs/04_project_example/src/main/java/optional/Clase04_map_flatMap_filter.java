package optional;

import data.Bike;
import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class Clase04_map_flatMap_filter {

    //filter()
    public static void optionalFilter(){
        Optional<Student> optionalStudent
                = Optional.ofNullable( StudentDataBase.studentSupplier.get());

        optionalStudent
                .filter(student -> student.getGpa() >= 3.5) //filtramos desde el optional si el estudiante tiene un gpa >= 3.5
                .ifPresent(System.out::println); //imprimimos ese estudiante si cumple la condicion

    }

    //map()
    public static void optionalMap(){
        Optional<Student> optionalStudent
                = Optional.ofNullable( StudentDataBase.studentSupplier.get());

        if (optionalStudent.isPresent()){
            Optional<String> stringOptional = optionalStudent
                                                .filter(student -> student.getGpa() >= 3.5)
                                                .map(Student::getName); //Optional<Student> -> Optional<String>
            System.out.println("Optional String: " + stringOptional.get());
        }
    }

    //flatMap() - Creamos una nueva clase Bike dentro de Data
    // Vamos a usar este método cuando tenemos más de un nivel de Optionals - en este caso Optional<Student> y dentro un Optional<Bike>
    public static void optionalFlatmap(){
        //Queremos imprimir el nombre de la Bike

        Optional<Student> optionalStudent
                = Optional.ofNullable( StudentDataBase.studentSupplier.get());

        Optional<String> name = optionalStudent
                .filter(student -> student.getGpa() >= 3.5) //Optional<Student <Optional<Bike>>
                .flatMap(Student::getBike) //con este método pasamos de tener un objeto Optional<Student> a un Optional<Bike>
                .map(Bike::getName); //Optional<Bike> -> Optional<String>

        name.ifPresent(s -> System.out.println("Optional flatMap name: " +  s));
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatmap();
    }
}
