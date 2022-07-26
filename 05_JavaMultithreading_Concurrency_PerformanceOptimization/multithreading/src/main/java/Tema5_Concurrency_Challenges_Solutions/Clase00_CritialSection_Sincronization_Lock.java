package Tema5_Concurrency_Challenges_Solutions;

public class Clase00_CritialSection_Sincronization_Lock {

    /*
     *PARA LOGAR ESTO, USAREMOS SYNCHRONIZED-MONITOR/LOCK
        @Synchronized - Lock -> vamos a bloquear porciones de código

            public class ClassWithCriticalSections{
                Object lockingObject = new Object(); -> bloqueamos el objeto
                public synchronized void method1(){
                   ..... //CONCURRENT EXECUTION
                   ..... //CONCURRENT EXECUTION
                   synchronized(lockingObject){
                        *CRITICAL SECTION* //NON-CONCURRENT EXECUTION
                   }
                   ..... //CONCURRENT EXECUTION
                }
                public synchronized void method2(){...}
            }

            En este esquema, si un Thread A accede a ejecutar un método cauqluiera, ningun otro método podrá ejecutar ninguno de ellos,
            dado que el syncronized se aplica por objeto
            *  Synchronized block is Reentrant
            *  A thread cannot prevent itself from entering a critical section

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

        @Override
        public void  run(){
            for (int i = 0; i < 10000; i++) {
                this.inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread{

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter){
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void  run(){
            for (int i = 0; i < 10000; i++) {
                this.inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter{
        private int items = 0;

        //Creamos el objeto Lock
        Object lock = new Object();

        public  void increment(){
            synchronized (this.lock){
                this.items++;
            }
        }

        public  void decrement(){
            synchronized (this.lock){
                this.items--;
            }
        }

        public  int getItems(){
            synchronized (this.lock){
                return this.items;
            }
        }
    }
}
