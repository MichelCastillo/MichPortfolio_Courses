package Tema2_ThreadInterrupt;

import java.math.BigInteger;

public class Clase00_ThreadTermination_DaeomonThreads_Example2 {

    public static void main(String[] args) {

        //Creamos el thread de mas abajo
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("1000000000")));

        //Ejecutamos el thread
        thread.start();

        //Debido a que es una ejecucion demasiado larga, ni el thread es suficiente para pararlo
        thread.interrupt(); //Para solucionar esto, debemos identificar en qué parte de nuestro codigo es la de gran procesamiento

    }

    //Cerando una tarea que tenga una gran carga de computacion
    private static class LongComputationTask implements Runnable {

        private BigInteger base, power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println("Base: " + base + ", Power: " +  power + " -> Result: " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0 ; i = i.add(BigInteger.ONE)){
                //Esta es la parte de mayor carga
                //agregamos un if
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("El thread fue INTERRUMPIDO antes de que terminara..");
                    return BigInteger.ZERO;
                }
              result = result.multiply(base);
            }

            return result;
        }
    }
}
