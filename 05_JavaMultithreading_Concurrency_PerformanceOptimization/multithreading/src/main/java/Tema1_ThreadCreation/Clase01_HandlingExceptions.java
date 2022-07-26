package Tema1_ThreadCreation;

public class Clase01_HandlingExceptions {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Lanzamos la ex que creamos más abajo
                throw new RuntimeException("Intentional exception");
            }
        });

        thread.setName("Mich's thread");

        //Agregando control de excepciones
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName() + " and the error message is " + e.getMessage());
            }
        });
        thread.start();
    }
}
