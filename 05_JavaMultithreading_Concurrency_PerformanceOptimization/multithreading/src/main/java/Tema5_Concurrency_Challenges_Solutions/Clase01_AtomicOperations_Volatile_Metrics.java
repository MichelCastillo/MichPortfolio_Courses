package Tema5_Concurrency_Challenges_Solutions;

import java.util.Random;

public class Clase01_AtomicOperations_Volatile_Metrics {
    /*

    Atomic Operations: Which operations are atomic?
        - All reference assignments are atomic
        - We can get and set references to objects atomically
            Object a = new Object();
            Object b = new Object();
            a = b; // atomic
        - Getters and Setters
        - All assignments to primitive types are safe EXCEPT LONG AND DOUBLE
            That means reading from, and writing to the following types: int, short, byte, float, char, boolean
        - Classes in the java.util.concurrent.atomic (more advanced operations)

    Volatile:
    Problema con long y double

    [UPPER 32 BITS][LOWER 32 BITS] -> Puede ocurrir que el OS maneje esos datos en 2 operaciones

        - Si asignamos volatile a long y double, los hacemos thread-safe
            volatile double x = 1.0;
            volatile double y = 9.0
            x = y; // atomic

    Metrics Use Case:

    public class BussinessLogicClass{
        public void businessLogic(){
            long start = System.currentTimeMillis();
            //important operation
            long end = System.currentTimeMillis();
        }
    }
    */

    public static void main(String[] args) {
        Metrics metrics = new Metrics();

        BusinessLogic businessLogic1 = new BusinessLogic(metrics);
        BusinessLogic businessLogic2 = new BusinessLogic(metrics);

        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        businessLogic1.start();;
        businessLogic2.start();
        metricsPrinter.start();
    }

    public static class Metrics{

        private long count = 0;
        private volatile double average = 0.0;

        public synchronized void addSample(long sample){ //al no ser una operacion atomica, debemos agregar el synchronized
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage(){ //debido a que es un get, es atomico, por ende thread-save pero al ser double, debemos declarar volatile al atributo
            return average;
        }
    }

    public static class BusinessLogic extends Thread{
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics){
            this.metrics = metrics;
        }

        @Override
        public void run(){
            long start = System.currentTimeMillis();

            while (true){
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    System.out.println("ERROR OCCURED - " + e);
                }

                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

    public static class MetricsPrinter extends Thread{
        private Metrics metrics;

        public MetricsPrinter(Metrics metrics){
            this.metrics = metrics;
        }

        @Override
        public void run(){
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                double currentAverage = metrics.getAverage();
                System.out.println("Current average is: " + currentAverage);
            }
        }
    }

}
