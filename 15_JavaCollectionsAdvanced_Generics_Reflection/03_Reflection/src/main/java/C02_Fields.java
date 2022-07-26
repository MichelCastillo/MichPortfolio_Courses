import java.lang.reflect.Field;

public class C02_Fields {

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
    }
}
