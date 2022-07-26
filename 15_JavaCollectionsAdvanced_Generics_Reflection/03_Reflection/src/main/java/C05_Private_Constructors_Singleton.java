import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class C05_Private_Constructors_Singleton {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        System.out.println("########################### ACCESSING TO TEST CLASS");
        Constructor<Test> constructor = Test.class.getDeclaredConstructor();

        /*We can instantiate a class with reflection despite the fact that It has private constructor !*/
        // Otra forma de implementar Singleton sería usando ENUMS

        // we can instantiate a new class
        constructor.setAccessible(true);
        Test test = constructor.newInstance();

        System.out.println(test);

    }
}
