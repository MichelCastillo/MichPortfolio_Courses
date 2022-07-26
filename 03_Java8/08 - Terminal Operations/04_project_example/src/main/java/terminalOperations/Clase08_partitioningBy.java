package terminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Clase08_partitioningBy {
    //is also a kind of groupingBy collector.
    //accepts a predicate as ain input
    //Return type of the colelctor is going to be Map<K, V>. The key of the return type is going to be a boolean
    //There are two different versions of partitioningBy()
    // - partitioningBy(predicate)
    // - partitioningBy(predicate, downstream) -> downstream could be of any collector

    //Lo que vamos a hacer es  agreupar en falso a aquellos alumnos que no cumplan con el predicado y en true los que si
    public static Map<Boolean, List<Student>> partitioningBy_1(){
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;

        return StudentDataBase.getAllStudents().stream()
                .collect(
                        Collectors.partitioningBy(
                                gpaPredicate
                        )
                );
    }

    public static Map<Boolean, Set<Student>> partitioningBy_2(){
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;

        return StudentDataBase.getAllStudents().stream()
                .collect(
                        Collectors.partitioningBy(
                                gpaPredicate, Collectors.toSet()
                        )
                );
    }

    public static void main(String[] args) {
        //PartitioningBy version 1
        System.out.println(partitioningBy_1());

        //PartitioningBy version 2
        System.out.println(partitioningBy_2());
    }

}
