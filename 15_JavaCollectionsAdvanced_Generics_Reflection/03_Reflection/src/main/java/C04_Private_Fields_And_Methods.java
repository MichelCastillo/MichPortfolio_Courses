import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C04_Private_Fields_And_Methods {

    public static void main(String[] args) {

        Class<PrivatePerson> personClass = null;

        try {
            personClass = (Class<PrivatePerson>) Class.forName("PrivatePerson");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*Getting private fields using getDeclaredFields*/
        System.out.println("###########################PRIVATE FIELDS");
        Field[] fields = personClass.getDeclaredFields();

        for (Field f:
             fields) {
            f.setAccessible(true);
            System.out.println(f.getName());
        }

        /*Getting private methods using getDeclaredMethods*/
        System.out.println("###########################PRIVATE METHODS");
        Method[] methods = personClass.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
        }

    }
}
