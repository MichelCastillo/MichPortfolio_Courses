package Tema2_ThreadInterrupt;

import java.math.BigInteger;

public class Clase00_ThreadTermination_DaeomonThreads_Example3 {

    public static void main(String[] args) {

        //Creamos el thread de mas abajo
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("1000000000")));

        //Declaramos el thread como un demonio
        thread.setDaemon(true);

        //Ejecutamos el thread
        thread.start();

        thread.interrupt();

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
              result = result.multiply(base);
            }

            return result;
        }
    }
}
