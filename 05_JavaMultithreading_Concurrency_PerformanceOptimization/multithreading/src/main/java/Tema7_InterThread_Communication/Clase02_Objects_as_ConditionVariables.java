package Tema7_InterThread_Communication;

public class Clase02_Objects_as_ConditionVariables {

    /*

    wait(), notify() and notifyAll()
        - The object Class contains the following methods:
            - public final void wait() throws InterruptedException
                - Causes the current thread to wait until another thread wakes it up
                - in the wait state, the thread is NOT consuming any CPU
                - There are two ways to wake up the waiting thread: notify() y notifyAll()
            - public final void notify()
                - Wakes up a single thread waiting on that object
            - public final void notifyAll()
                - Wakes up all the threads waiting on that object
        - To all wait(), notify() or notifyAll() we need to acquire the monitor of that object (use synchronized on that object)
        - Every Java Class inherits from the Object Class
        - We can use any object as a condition variable and a lock (using the synchronized word)

    How to use it:
        public class MySharedClass{
            //Declaramos una bandera, que nos va a permitir saber si una tarea se completó o no
            private boolean isComplete = false;

            public void waitUntilComplete() throws InterruptedException {
                synchronized (this){
                    while (isComplete == false){ //En caso de que la tarea aun no se completó, este thread se va a suspender
                        this.wait();
                    }
                }
                ...
            }

            public void complete(){
                synchronized (this){
                    isComplete = true;
                    this.notify(); //Esto le va a avisar al thread que estaba esperando que termine de completarse la operación, para seguirse ejecutando
                }
            }
        }

    Object Signalling vs Condition Variables

        Object Signalling                   Condition Variable
        --------------------------          --------------------------
        synchronized(object){               lock.lock()
        }                                   lock.unlock()
        object.wait()                       condition.await()
        object.notify()                     condition.signal()
        object.notifyAll()                  condition.signalAll()

    Ejemplo: Va  a ser un pipeline donde entran 2 inputs y devuelve otra
    */



}
