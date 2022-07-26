package defaults;

public interface Clase04_HerenciaMultiple_issues {

    default void methodA(){
        System.out.println("INSIDE METHODA() INSIDE INTERFACE - " + Clase04_HerenciaMultiple_issues.class);
    }
}
