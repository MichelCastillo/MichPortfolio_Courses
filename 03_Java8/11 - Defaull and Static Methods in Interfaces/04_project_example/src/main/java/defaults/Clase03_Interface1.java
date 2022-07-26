package defaults;

public interface Clase03_Interface1 {

    default void methodA(){
        System.out.println("INSIDE METHODA() INSIDE INTERFACE - " + Clase04_HerenciaMultiple_issues.class);
    }
}
