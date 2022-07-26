import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class C07_Annotations {

    public static void main(String[] args) {

        Class<Person> personClass = null;

        try {
            personClass = (Class<Person>) Class.forName("PersonAnnotation");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = personClass.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(myAnnotation.class)){
                System.out.println(method.getName());
            }
        }

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface myAnnotation{
    public String name();
}

class PersonAnnotation{
    private String name;
    private int age;

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

    @myAnnotation(name="myAnnotation")
    public String returnName(){
        return this.name + " is the name";
    }

}
