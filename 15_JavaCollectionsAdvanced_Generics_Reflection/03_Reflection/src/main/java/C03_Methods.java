import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C03_Methods {

    public static void main(String[] args) {

        // Get the person Class
        Class<Person> person = Person.class;

        // get the packages that has the class Person
        System.out.println(person.getPackage());

        // Get person fields
        Field[] fields = person.getFields();

        for (Field field : fields) {
            System.out.println(field.getName()); // si los atributos de la clase están difinidos como privados, no los vamos a poder acceder (solo public)
        }

        System.out.println("################################################# METHODS");
        Method[] methods = person.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " return type -> " + method.getReturnType());
        }
    }
}
