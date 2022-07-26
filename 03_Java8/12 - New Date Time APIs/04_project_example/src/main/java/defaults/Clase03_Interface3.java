package defaults;

public interface Clase03_Interface3 extends Clase03_Interface2{
    default void methodC(){
        System.out.println("INSIDE METHODC()");
    }
}
