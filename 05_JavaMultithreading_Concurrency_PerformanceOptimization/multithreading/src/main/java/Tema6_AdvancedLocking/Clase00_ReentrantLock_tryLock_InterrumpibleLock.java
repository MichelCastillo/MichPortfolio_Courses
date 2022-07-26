package Tema6_AdvancedLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clase00_ReentrantLock_tryLock_InterrumpibleLock {

     /*
     - java.util.concurrent.locks.ReentrantLock
            - works just like the synchronized kerword applied on an object
            - requires explicit locking and unlocking
                Lock lockObject = new ReentrantLock(); -> en vez de crear un objeto cualquiera, creamos un ReentrantLock
                Resource resource = new Resource();

                ...

                public void method(){ -> y ahora en vez de bloquear el recurso perse, lockeamos el lockObject
                    lockObject.lock();
                    ...
                    use(resource);
                    throwExceptionMethod() -> también puede ocurrir que se levante una excepción antes de que termine, cayendo de nuevo en un deadlock xq
                                                el método unlock() nunca va a ser llamado (una posible solución, es colocar el unlock en un finally de un try-catch
                    ...
                    lockObject.unlock(); -> el unico problema, es que se nos olvide desbloquear el objeto, por lo que caeríamos de nuevo en deadlocks

               }

            - Why? -> Agregando esta complejidad, ganamos
                - mayor control sobre el bloqueo
                - más operaciones de bloqueo:
                    - getQueuedThreads(): Returns a list of threads waiting to acquire a lock
                    - getOwner(): Returns the thread that currently owns the lock
                    - isHeldByCurrentThread(): Queries if the lock is held by the current thread
                    - isLocked(): Queries if the lock is held by any thread
                - Every production code need to be thoroughly tested
                - For that methods like isLocked(), getQueuedThreads() and others can be very handy
                - Another area where the ReentrantLock shines is the control over lock's fairness
                - By default, the ReentrantLock as well as synchronized keyword do NOT guarantee any fairness
                    - Con esto puede ocurrir que un mismo thread bloquee varias veces el recurso, y otros threads esperen mucho tiempo
                    - Para solucionarlo, pasamos un true al constructor
                        ReentrantLock(true)
                    - A su vez, esto puede incurrir a que se reduzca el throughput(rendimiento) de la aplicación

        - ReenterantLock.lockInterruptibly()

            public class SomeThread extends Thread{

            Lock lockObject = new ReentrantLock();
            @Override
            public void run() {
                while(true){
                    lockObject.lock(); //Puede ocurrir que si este objeto esta siendo bloqueado por otro thread, este thread se quede sperando indefinidamente
                                        //Por eso usamos el método lockIterruptible(); el cual en caso de que el interrumpamos el thread con el método interrupt()
                                        //Este va a ir al catch, y se va a liberar
                    try {
                        lockObject.lockInterruptibly();
                    } catch (InterruptedException){
                        cleanUpAndExit();
                    }
                    ...
                }
            }
        }

            Use cases:
                - Watchdog for deadlock detection and recovery
                - Waking up threads to do clean and close the application

        - ReenterantLock.tryLock()
            - boolean tryLock()
            - boolean tryLock(long timeout, TimeUnit unit);
                - Returns true and acquires a lock if available
                - Returns false and does not get suspended, if the lock is unavailable
        - lock() vs tryLock()
            public void methodLock(){
                lockObject.lock(); -> EN ESTE CASO, cuando otro thread este usando el recurso, este thread se va a suspender hasta que el otro termine
                try {
                    useResource();
                }
                finally {
                    lockObject.unlock();
                }
            }

            public void methodTryLock(){
                if (lockObject.tryLock()){ -> EN ESTE CASO, si otro thread está usando el recurso, este no se bloqueará y ejecutara la rama del else
                    try {
                        useResource();
                    }
                    finally {
                        lockObject.unlock();
                    }
                } else {
                    ...
                }
            }

            - Under no circumstances doeas the tryLock() method lock
            - Regardless of the state of the lock, it always returns immediately.
            - Use cases:
                - Real time applications where suspending a thread on a lock() methods is unacceptable
                    - video/image processing
                    - High Speed/Low latency trading systems
                    - User Interface applications which use threads
      */

    Lock lockObject = new ReentrantLock();


}
