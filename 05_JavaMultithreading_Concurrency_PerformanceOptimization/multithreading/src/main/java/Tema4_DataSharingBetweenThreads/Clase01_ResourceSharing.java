package Tema4_DataSharingBetweenThreads;

public class Clase01_ResourceSharing {

    /*
    Resource: Variables, Datastructure, file or connection handles, Message or work queues, objects

    What we can share? Everything that is in the HEAP (Objects, Class members, Static variables)
    Why do we want to share resources?
    What is the problem of sharing resources?
    */

    public static void main(String[] args) throws InterruptedException {

        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        //Bajo este esquema no deberia haber problema
        //incrementingThread.start();
        //incrementingThread.join();

        //decrementingThread.start();
        //decrementingThread.join();

        //Con este esquema vamos a tener un error
        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();
        System.out.println("We currently have " + inventoryCounter.getItems() + " items.");

        //Al estar compartiendo el InventoryCounter en varios Threads, esto puede caer en error de concurrencia

        /*
        Para solucionar esto, podemos usar los llamados ATOMIC OPERATIONS
            - An operation or set of operations is considered atomic, if it appears to the rest of the system as if it occurred at once.
            - Single step - "all of nothing"
            - No intermediate states

            Operation: item++ -> son 3 operaciones (no es atómico)
                1. Get current value of items
                2. Increment current value by 1;
                3. Store the result into items
        */

    }

    public static class InventoryCounter{
        private int items = 0;

        public void increment(){
            this.items++;
        }

        public void decrement(){
            this.items--;
        }

        public int getItems(){
            return this.items;
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
}
