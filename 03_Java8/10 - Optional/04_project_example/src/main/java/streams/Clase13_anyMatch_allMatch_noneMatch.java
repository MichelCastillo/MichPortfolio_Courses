package streams;

import data.StudentDataBase;

public class Clase13_anyMatch_allMatch_noneMatch {

    //All these functions takes in a predicate as an input an returns a Boolean as an output
    //anyMatch() - returns true if any one of the element matches the perdicate, otherwise false
    public static boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>= 3.5);//Se va a fijar si al menos 1 de los estudiantes en esa lista, tienen GPA >= 3.9
    }

    //allMatch() - returns true if all the element in the stream matches the predicate, otherwise false
    public static boolean allMatch(){
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>= 3.5);//Se va a fijar si todos los estudiantes en esa lista, tienen GPA >= 3.9
    }

    //noneMatch() - just opposite to allMatch(). Returns true if none of the element in the stream matches the predicate, otherwise false
    public static boolean noneMatch(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>= 4.0);//Se va a fijar si ninguno de los estudiantes en esa lista, tienen GPA >= 3.9
    }

    public static void main(String[] args) {
        //allMatch
        System.out.println("All match result: " + allMatch());

        //anyMatch
        System.out.println("Any match result: " +  anyMatch());

        //noneMatch
        System.out.println("None match result: " +  noneMatch());
    }
}
