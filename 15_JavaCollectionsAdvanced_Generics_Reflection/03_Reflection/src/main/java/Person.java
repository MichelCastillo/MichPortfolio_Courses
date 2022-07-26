import java.io.Serializable;

class Employee{

}

/*public class Person extends Employee{*/
public class Person implements Comparable<Person>, Serializable {

    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String returnName(){
        return this.name + " is the name";
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
