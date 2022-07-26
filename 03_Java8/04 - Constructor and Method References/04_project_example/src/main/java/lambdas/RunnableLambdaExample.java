package lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {
        // Prior Java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola desde dentro de una implementacion de clase anónima de Runnable!");
            }
        };

        //Creamos un hilo para nuestra nueva clase runnable
        new Thread(runnable).start();

        // Java 8 lambda sintax for implementing Runnable interface
        Runnable runnableLambda = () -> {
            System.out.println("Hola desde dentro de una implementación Lambda de Runnable");
        };

        new Thread(runnableLambda).start();

        // Most simplified way of that lambda implementation
        Runnable runnableLambdaSimplified = () -> System.out.println("Hola desde la implementacion simplificada de Lambda");

        new Thread(runnableLambdaSimplified).start();

        //Passing a runnable interface directly to Thread
        new Thread(() -> System.out.println("Hola desde dentro de una implementacion Lambda directo en el Thread,")).start();
        //Esto es posible ya que los parámetros que recibe Thread() es una expresion lambda Runnable

        //In case we got more than 1 lines in the Lambda body, we have to use []
    }

}
