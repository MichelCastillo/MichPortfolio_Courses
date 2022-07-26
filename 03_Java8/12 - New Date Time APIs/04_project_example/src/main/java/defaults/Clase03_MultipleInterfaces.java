package defaults;

public class Clase03_MultipleInterfaces implements Clase03_Interface1, Clase03_Interface2, Clase03_Interface3{

    public static void main(String[] args) {

        Clase03_MultipleInterfaces client = new Clase03_MultipleInterfaces();
        client.methodA(); // Toma prioridad la implementación más especifica del metodo, es decir, del methdoA de interface2
        client.methodB();
        client.methodC();
    }
}
