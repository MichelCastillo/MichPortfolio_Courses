package terminalOperations;

import data.StudentDataBase;

import java.util.stream.Collectors;

public class Clase02_counting {

    //Collector - counting() - reutnr the total number of elements as a result
    public static long counting(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9) //adding a filter
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println("counting(): " + counting());
    }
}
