package streams;

import data.Student;
import data.StudentDataBase;

public class Clase10_MapFilterReduce {

    //Agregamos un parámetro adicional a los objetos Student - cantidad de notebooks
    //Ahora vamos a averiguar cuantas notebooks tiene toda la coleccion
    public static int noOfNotebooks(){
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .filter(student -> student.getGradeLevel() >= 3) //Adding a filter
                .filter(student -> student.getGender().equals("female")) //Adding a filter
                .map(Student::getNoteBooks) //Stream<Integer>
                //.reduce(0, (a,b) -> a+b)
                .reduce(0, Integer::sum) //Method reference way
                ;
    }

    public static void main(String[] args) {
        System.out.println("Total of notebooks: " + noOfNotebooks());
    }
}
