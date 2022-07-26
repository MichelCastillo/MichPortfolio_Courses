package Clase01_BoundedGenericTypes;

public class C00_BoundedTypeParameters {

    public static <T extends Comparable<T>> T calculateMin(T num1, T num2){
        //Necesitamos extender de Comparable para poder comparar objetos del mismo tipo
        return num1.compareTo(num2) < 0 ? num1 : num2;
    }

    public static void main(String[] args) {

        System.out.println("Mínimo entre numeros enteros: " + calculateMin(230, 45));
        System.out.println("Minimo entre cadenas: " + calculateMin("Mich", "Agustin"));

        //Comparamos objetos de tipo persona
        System.out.println("Comparing persons: " + calculateMin(new Person(25, "Mich"), new Person(18, "Agustin")));

    }

    static class Person implements Comparable<Person>{

        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(age, o.getAge());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
