package defaults;

public interface Clase03_Interface2 extends Clase03_Interface1{

    default void methodB(){
        System.out.println("INSIDE METHODB()");
    }

    //Sobreescribiendo el metodo methdoA() de la interfaz 1
    default void methodA(){
        System.out.println("INSIDE METHOD A DESDE INTERFACE 2 - " + Clase03_Interface2.class);
    }
}
