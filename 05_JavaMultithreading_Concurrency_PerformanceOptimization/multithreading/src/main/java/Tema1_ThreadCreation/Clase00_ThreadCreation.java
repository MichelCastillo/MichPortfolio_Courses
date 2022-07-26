package Tema1_ThreadCreation;

public class Clase00_ThreadCreation {

    public static void main(String[] args) throws InterruptedException {

        //Creando un nuevo thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " +  Thread.currentThread().getName()); //Thread-0 -> Mich's thread
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        //Creando un Thread usando Java8+
        //Thread threadJava8 = new Thread(() -> {});

        //Asignandole un nombre al thread
        thread.setName("Mich's trhead.");

        //Asignando una prioridad al thread - MAX_PRIORITY, NORM_PRIORITY, MIN_PRIORITY
        thread.setPriority(Thread.MAX_PRIORITY);

        //Imprimiendo algo antes de arrancar un nuevo thread.
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread."); //main thread

        //Start a thread
        thread.start();

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread."); //main thread

        //Poniendo sleep a un thread
        Thread.sleep(10000);

    }
}
