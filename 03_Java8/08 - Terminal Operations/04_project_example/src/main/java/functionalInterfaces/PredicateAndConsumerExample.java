package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    //Creating a Predicate
    Predicate<Student> predicateStudentGradeLevel = student -> student.getGradeLevel() >= 3;
    Predicate<Student> predicateStudentGpa = student -> student.getGpa() >= 3.9;

    //Creating a BiConsumer - just to use both predicates we created above
    BiConsumer<String, List<String>> studentBiConsumer =
            (name, activities) -> System.out.println(name + " : " + activities);

    //Creating a consumer using that BiConsumer to print the name and the activities for the students that were filter by both predicates
    Consumer<Student> studentConsumer = student -> {
        if (predicateStudentGradeLevel.and(predicateStudentGpa).test(student)){
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    public void printNameAndActivities(List<Student> students){
        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {

        List<Student> students = StudentDataBase.getAllStudents();

        //Executing that printNameAndActivities method.
        new PredicateAndConsumerExample().printNameAndActivities(students);

    }

}
