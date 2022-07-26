public class C06_Superclasses_Interfaces {

    public static void main(String[] args) {

        Class<Person> personClass = null;

        try {
            personClass = (Class<Person>) Class.forName("PrivatePerson");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Interfaces
        Class[] intefaces = personClass.getInterfaces();

        for (Class inteface : intefaces) {
            System.out.println(inteface.getName());
        }

        // Superclass
        System.out.println(personClass.getSuperclass().getName());



    }

}
