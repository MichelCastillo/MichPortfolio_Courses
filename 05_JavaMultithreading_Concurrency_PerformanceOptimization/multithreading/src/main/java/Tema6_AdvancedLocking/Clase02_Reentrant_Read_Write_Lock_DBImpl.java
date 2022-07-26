package Tema6_AdvancedLocking;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Clase02_Reentrant_Read_Write_Lock_DBImpl {

    /*

    Race Conditions require:
        - Multiple threads sharing a resource
        - At least one thread modifying the resource

    Solution: Complete mutual exclusion
        - Regardless of operation (read/write/both)
        - Lock and allow only one thread to critical section

    Use case: usamos de ejemplo un caso donde varios Readers leen desde una caché, donde es updateado periodicamente por un Writer.
        - Synchronized and ReentrantLock do not allow multiple readers to access a shared resource concurrently.
        - Not a big problem in the general case
        - If we keep the critical sections short, the chances of a contention over a lock are minimal

    ReentrantReadWriteLock - WHEN TO USE?:
        - when read operations are predominant
        - When the read operations are not as fast
            - Read from many variables
            - Read from a complex data structure
        - Mutual exclusion of reading threads negatively impacts the performance

     How to use:
        //creamos la instancia
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        //Creamos las implementaciones para el READ y el WRITE
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();

        public void methodWrite(){ //Solo un thread a la vez va a poder escribir
            writeLock.lock();
            try {
                modifySharedResources();
            } finally {
                writeLock.unlock();
            }
        }

        public void methodRead(){ //varios threads al mismo tiempo pueden acceder al readLock (este va contanto la cantidad de threads leyendo dentro del propio lock)
            readLock.lock();
            try {
                modifySharedResources();
            } finally {
                readLock.unlock();
            }
        }

        //Y a su vez, ambos locks son mutuamente excluyentes, es decir. Ningun reader thread va a poder acceder al recurso, hasta que el write thread lo desocupe y viceversa.
    */

    //Definimos el mayor precio
    public static final int HIGHEST_PRICE = 1000;


    public static void main(String[] args) {
        InventoryDatabase inventoryDatabase = new InventoryDatabase();

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
        }

        //Creamos el writer, para agregar y eliminar un elemento random
        Thread writer = new Thread(() -> {
            while (true){
                inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
                inventoryDatabase.removeItem(random.nextInt(HIGHEST_PRICE));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        });

        //lo dejamos como un demonio que corre por debajo
        writer.setDaemon(true);
        writer.start();

        //Creamos una colección de 7 readers
        int numberOfReaders = 6;
        List<Thread> readers = new ArrayList<>();

        //creamos los readers, con la misma operaciones de lectura que el writer de escritura
        for (int i = 0; i < numberOfReaders; i++) {
            Thread reader = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
                    int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
                    inventoryDatabase.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
                }
            });

            reader.setDaemon(true);
            readers.add(reader);
        }

        long startReadingTime = System.currentTimeMillis();

        readers.forEach(reader -> {
            reader.start();
            try {
                reader.join();
            } catch (InterruptedException e) {
            }
        });

        long endReadingTime = System.currentTimeMillis();

        System.out.println(String.format("Reading took %d ms", endReadingTime - startReadingTime));
    }

    public static class InventoryDatabase {
        private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();

        //Creamos el ReentrantLock para ver que se puede acceder al treeMap de arriba concurrentemente
        ReentrantLock lock = new ReentrantLock();

        //Ahora reemplazamos el ReentrantLock por el ReentrantReadWriteLock
        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = reentrantReadWriteLock.readLock();
        private Lock writeLock = reentrantReadWriteLock.writeLock();

        public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound){
            //bloqueamos el ReentrantLock
            //lock.lock();

            //Reemplazamos por el readLock, dado que acá solo se lee
            readLock.lock();

            //Agregamos el try para usar el lock
            try {

                Integer fromKey = priceToCountMap.ceilingKey(lowerBound);
                Integer toKey = priceToCountMap.floorKey(upperBound);

                if (fromKey == null || toKey == null) return 0;

                NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

                return rangeOfPrices.values().stream()
                        .reduce(Integer::sum).orElseGet(() -> 0);
            } finally {
                //lock.unlock();
                readLock.unlock();
            }
        }

        public void addItem(int price){
            //lock.lock();

            //Modificamos el lock original por el writeLock
            writeLock.lock();

            try {
                Optional<Integer> numberOfItemsForPrice = Optional.ofNullable(priceToCountMap.get(price));

                if (numberOfItemsForPrice.isEmpty()) {
                    priceToCountMap.put(price, 1);
                } else {
                    priceToCountMap.put(price, numberOfItemsForPrice.get() + 1);
                }
            } finally {
                //lock.unlock();
                writeLock.unlock();
            }
        }

        public void removeItem(int price){
            //lock.lock();
            writeLock.lock();
            try {
                Optional<Integer> numberOfItemsForPrice = Optional.ofNullable(priceToCountMap.get(price));
                if (numberOfItemsForPrice.isEmpty()) {
                    priceToCountMap.remove(price);
                } else {
                    priceToCountMap.put(price, numberOfItemsForPrice.get() - 1);
                }
            } finally {
                //lock.unlock();
                writeLock.unlock();
            }
        }

    }

    }
