package Tema5_Concurrency_Challenges_Solutions;

import Tema4_DataSharingBetweenThreads.Clase01_ResourceSharing;

public class Clase00_CritialSection_Sincronization {

    /*
    The concurrency problem:
        - Two threads sharing the items counter
        - Both threads are reading and modifying that counter in the same time
        . The operation were not atomic

        Critical Section
        void aggregateFunction(){
            *enter critical section*
            operation1(); -x-> Thread B
            operation2(); -> Thread A (si el thread A) hicera todas las operaciones evitando que otro thread entre a la zona critica, no habria issues
            operation3();
            *exit critical section*

        }

        *PARA LOGAR ESTO, USAREMOS SYNCHRONIZED-MONITOR/LOCK
        @Synchronized
                - Locking mechanism
                - Uset to restrict access to a critical section or entire method to a single thread at a time

            public class ClassWithCriticalSections{
                public synchronized void method1(){...}
                public synchronized void method2(){...}
            }

            En este esquema, si un Thread A accede a ejecutar un método cauqluiera, ningun otro método podrá ejecutar ninguno de ellos,
            dado que el syncronized se aplica por objeto

    */

    public static void main(String[] args) throws InterruptedException {

        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();
        System.out.println("We currently have " + inventoryCounter.getItems() + " items.");
    }

    public static class DecrementingThread extends Thread{

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        //Usamos RUN para llamar el método decrease 10000 veces
        @Override
        public void  run(){
            for (int i = 0; i < 10000; i++) {
                this.inventoryCounter.decrement();
            }
        }
    }

    //Creando a un Thread que incremente
    public static class IncrementingThread extends Thread{

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        //Usamos RUN para llamar el método increase 10000 veces
        @Override
        public void  run(){
            for (int i = 0; i < 10000; i++) {
                this.inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter{
        private int items = 0;

        public synchronized void increment(){
            this.items++;
        }

        public synchronized void decrement(){
            this.items--;
        }

        public synchronized int getItems(){
            return this.items;
        }
    }
}
