import Vehicle.*;

public class C01_GetClass {

    public static void main(String[] args) {

        //First method to acquire the class
        Class<Person> personC = Person.class;

        System.out.println(personC.getName()); //devolvemos el nombre de la clase

        // Second way to get the class Name
        Class personClass = null;
        try {
            personClass = Class.forName("Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(personClass.getName());

        checkClass(new Bus());

    }

    public static void checkClass(Vehicle v){
        Class c = v.getClass();
        System.out.println(c.getName());
    }
}
