package Tema7_InterThread_Communication;

import java.util.concurrent.Semaphore;

public class Clase00_Semaphore {

    /*

    Semaphore:
        - Can be used to restrict the number of "users" to a particular resource or a group of resources
        - Unlike the locks that allows only one "user" per resource
        - The semaphore can restrict any given number of users to a resource

    How to use:
        - 1 permits available
            Semaphore semaphore = new Semaphore(NUMBER_OF_PERMITS);
            semaphore.acquire();//NUMBER_OF_PERMITS -1 now available
        - 5 permits available
            Semaphore semaphore = new Semaphore(NUMBER_OF_PERMITS);
            semaphore.acquire(5);//NUMBER_OF_PERMITS -5 now available

            useResource()

            semaphore.release(5) //NUMBER_OF_PERMITS now available
        -- ALL permits used
            Semaphore semaphore = new Semaphore(NUMBER_OF_PERMITS);
            semaphore.acquire(NUMBER_OF_PERMITS);//NUMBER_OF_PERMITS -1 now available

            //Cualquier otro thread que quiera acceder a algun recurso, va a quedar suspendido


     Semaphore differences with Locks:
        - Semaphore does not have a notion of owner thread
        - Many threads can acquire a permit
        - The same thread can acquire the semaphore multiple times
        - The binary semaphore (initialized with 1) IS NOT REENTRANT
        - Semaphore can be released by any thread
        - Even can be released by a thread that has not actually acquired it

     Producer Consumer using Semaphores
        - 1 producer - 1 consumer
             public void method(){

                //Creamos un semaphoro para que el primer thread que lo tome, se suspenda
                Semaphore full = new Semaphore(0);

                //Creamos un semaforo binario
                Semaphore empty = new Semaphore(1);

                //creamos el recurso que va a ser compartido
                Item item = null;


            }

            public void producer(){
                while(true){
                    empty.acquire(); //Va a tomar el semaforo para empezar a trabajar (el binario)
                    item = produceNewItem(); //va a modificar el recurso
                    empty.release(); //va a dar luz verde a los consumidores para tomar el semaforo y x lo tanto, acceder al recurso item
                }
            }

            public void consumer(){
                while(true){
                    full.acquire(); //Se suspende el thread del consumidor
                    consume(item); //Consume el recurso
                    empty.release(); //Desocupa el semaphoro binario, lo que permite al producer crear nuevos items
                }
            }
         - Multiple Producers - Multiple Consumers
             public void method(){

            //Creamos un semaphoro para que el primer thread que lo tome, se suspenda
            Semaphore full = new Semaphore(0);

            //Creamos un semaforo binario
            Semaphore empty = new Semaphore(CAPACITY); //Esto va a ser basicamente la longitud de la queue

            //creamos el recurso que va a ser compartido (esta vez, una coleccion de ellos)
            Queue queue = new ArrayDeque();

            //Declaramos un ReentrantLock para evitar el acceso concurrente a la queue


        }

        public void producer(){
            while(true){
                Item item = produce();              //producimos le nuevo item
                empty.acquire();                    //Adquirimos el semaforo
                lock.lock();                        //evitamos que otros threads accedan a este recurso
                queue.offer(item);                  //agregamos el item a la queue
                lock.unlock();                      //desbloqueamos la cola
                full.release();                     //habilitamos el semáforo para que los consumers puedan leer el nuevo item
            }
        }

        public void consumer(){
            while(true){
                full.acquire();                     //Se suspende el thread del consumidor, hasta que el producer termine de generar el nuevo item
                lock.lock();                        //se bloquea el acceso a la cola
                Item item = queue.poll();           //se obtiene el siguiente elemento
                lock.unlock();                      //se desbloquea la cola
                consume(item);                      //Consume el recurso
                empty.release();                    //Desocupa el semaphoro binario, lo que permite al producer crear nuevos items
            }
        }
     */




}
