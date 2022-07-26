package functionalInterfaces;

public class FunctionExample1 {

    public static String performConcat(String str){
        //Usando las funciones que declaramos en la clase FunctionExample
        return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {
        String result = performConcat("Hello");

        System.out.println("Result: " +  result);
    }

}
