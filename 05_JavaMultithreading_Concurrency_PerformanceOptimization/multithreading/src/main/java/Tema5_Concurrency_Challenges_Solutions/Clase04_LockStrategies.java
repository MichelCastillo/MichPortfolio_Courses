package Tema5_Concurrency_Challenges_Solutions;

import java.util.Random;

public class Clase04_LockStrategies {
    /*

    Fine-Graned Locking:

    public class SharedClass{

        private DatabaseConnection dbConnection;
        private List<Task> tasksQueue;

        public Item getItemFromDB(){
            synchronized(dbConnection){...} //Puede ser accedido por el Thread 1
        }

        public void addTaskToQueue(){
            synchronized(tasksQueu){...]//y al ser synchronized, se evita que cualquier otro thread envie mas tasks a la queue mientras el Thread 1 lo esté usando
        }

        Con esta solución, podemos mejorar incluso más el multithreading
    }


    Coarse-Grained Locking:

    public class SharedClass{

        private DatabaseConnection dbConnection;
        private List<Task> tasksQueue;

        public synchronized Item getItemFromDB(){
            ... //Puede ser accedido por el Thread 1
        }

        public synchronized void addTaskToQueue(){
            ...//y al ser synchronized, se evita que cualquier otro thread envie mas tasks a la queue mientras el Thread 1 lo esté usando
        }

        El problema con esta solución, es que no serviria tener una estructura de Multithreading, debido a que durante cada ejecución de
        un método, se suspenderia ese método para el resto de threads
    }

    Deadlock: is a situation where everyone is trying to make progress but cannot because they are waiting for another party to make a move
    (Ejemplo de cruce de calles con autos atascados) - Dependencia circular - usualmente irrecuperable

    Thread 1                    Thread 2
    1. lock(A)
                                2. lock(B)
                                3. lock(A) *ESTA OPERACION NO SE PUEDE HACER* -> debido a que el recurso A lo está usando el Thread 1
                                            por lo que el Thread 2 se suspende hasta que el recurso A sea desocupado por el Thread 1
    4. lock(B) *ESTA OPERACION TAMPOCO SE PUEDE HACER* dado que el recurso B está lockeado por el Thread 2
    ***** DEADLOCK ***** -> Nadie puede avanzar


    */

    //vamos a simular una intersección de trenes, donde en la mitad, hay un mecanismo que switchea entre direcciones
    public static class Intersection{

        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA(){
            synchronized (roadA){
                System.out.println("Road A is locked by Thread " +  Thread.currentThread().getName());

                synchronized (roadB){
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

        public void takeRoadB(){
            synchronized (roadA){ //cambiamos de roadB -> roadA para que tenga el mismo orden de ejecución que el takeRoadA()
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

                synchronized (roadB){
                    System.out.println("Train is passing through road B");

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

    //Con la clase intersection creada, vamos a crear 2 threads, uno para cada tren
    public static class TrainA implements Runnable{
        private Intersection intersection;
        private Random random = new Random(); //Esto para crear un cronograma de circulación del tren

        public TrainA(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
                intersection.takeRoadA();
            }
        }
    }

    public static class TrainB implements Runnable{
        private Intersection intersection;
        private Random random = new Random(); //Esto para crear un cronograma de circulación del tren

        public TrainB(Intersection intersection){
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true){
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
                intersection.takeRoadB();
            }
        }
    }

    //Creamos el main para ver los resultados
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();

        /*
        Road A is locked by Thread Thread-0
        Train is passing through road A
        Road B is locked by thread Thread-1
        Train is passing through road B
        Road A is locked by Thread Thread-0
        Train is passing through road A
        Road A is locked by Thread Thread-0
        Road B is locked by thread Thread-1 //Acá vemos como ambos threads se bloquearon

        Deadlocks conditions:
            - Mutual exclusion: Only one thread can have exclusive access to a resource
            - Hold and Wait: At least one thread is holding a resource and is waiting for another resource
            - Non-preemptive allocation: A resource is released only after the thread is done using it
            - Circular wait: A chain of at least two threads each one is holding a resource and waiting for another resource

        Deadlocks solution:
            - Avoid Circular wait: Enforce a strict order in lock acquisition (en el ejemplo anterior, si colocamos el mismo orden en la ejecucion en ambos threads, nos vamos a tener un deadlock
                    Thread 1                    Thread 2
                    1. lock(A)
                                                2. lock(A)-> Este va a esperar a que el Thread 1 deslockee el recurso A
                                                3. lock(B)
                    4. lock(B) -> Va a esperar a que el Thread B deslockee el recurso B
            - Deadlock detection: implement a watchdog
            - Thread interruption (not possible with synchronized)
            - tryLock operations (not possible with synchronized)
        */

    }

}
