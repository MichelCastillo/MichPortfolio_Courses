package Tema7_InterThread_Communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clase01_ConditionVariables {

    /*

    RSemaphore as a Condition Var
        - Calling the acquire() on a Semaphore is equivalent to checking the condition "is Number of Permits > 0?"
        - If the condition is not met - the thread goes to sleep until another thread changes the semaphore's state
        - When that other thread calls the release() method, the first thread wakes up
        - Then, this thread checks again the condition "is Number of Permits > 0?", and if it is, continues to the next instruction

    Condition variables - java.util.concurrent.locks.Condition

    Inter-thread - Creation:
        - Condition variable is always associated with a lock
        - The lock ensures atomic check and modification of the shared variables, involved in the condition
        - Creation:
            //Supongamos el caso en donde tenemos un login donde q thread se va a encargar de la parte UI
            // y otro de ir a la BD a autenticar al usuario
            Lock lock = new ReentrantLock();
            Condition condition = lock.newCondition();
            String username = null, password = null;

            public void methodDBAutentication() throws InterruptedException {
                lock.lock();

                try {
                    while (username == null || password == null){
                        condition.await(); //esto hace que el lock se desbloquee (lock.unlock()) y pone al thread suspendido
                    }
                } finally {
                    lock.unlock();
                }
                doSomeStuff();
            }

            public void methodUI() throws InterruptedException {
                lock.lock();

                try {
                    username = userTextbox.getText();
                    password = passwordTextBox.getText();
                    condition.signal(); //Esto va a cambiar el estado de la condición, avisandole al thread de la autenticacion con la BD que puede proceder
                } finally {
                    lock.unlock();
                }
            }
    Inter-Threads - Condition.await();
        - void await() - unlock lock, wait until signalled
        - long awaitNanos(long nanosTimeout) - wait no longer than nanosTimeout
        - boolean await(long time, TimeUnit unit) - wait no longer than time, in given time units
        - boolean awaitUnit(Date deadline) - wake up before the deadline date

   Inter-Threads - Condition.signal()
        - wake sup a single thread, waiting on the condition variable
        - A thread that wakes up hast to reacquire the lock associated with the condition variable
        - If currently no thread is waiting on hte condition variable, the signal method does not do anything
            - Esta es la diferencia principal con el semaforo

    Inter-Threads - Condition.signalAll()
        - Broadcast a signal to all threads currently waiting on the condition variable.
        - Does not need to know how many (if at all) threads are waiting on the condition variable
            - Otra diferencia con el semaforo

    */



}
