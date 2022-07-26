package Tema2_ThreadInterrupt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clase01_JoiningThreads {

    //El use case es calcular el factorial de una serie de numeros
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(100000L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
        List<FactorialThread> threads = new ArrayList<>();

        //La idea es calcular el factorial de todos esos números en diferentes threads
        for (long input : inputNumbers){
            threads.add(new FactorialThread(input));
        }

        threads.forEach(FactorialThread::start);

        //Para poder obtener todos los factoriales juntos
        //Pero que sucede si uno de los numeros es muy grande? pasamos por parámetro el tiempo maximo para esperar un join

        for (Thread thread: threads
             ) {
            thread.join(200);
        }


        for (int i = 0 ; i < inputNumbers.size() ; i++){
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished){
                System.out.println("Factorial of: " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for: " + inputNumbers.get(i) + " is still in progress");
            }
        }

        //Con esto de arriba demostramos de que el calculo de cada uno de los factoriales se hace en paralelo, en threads separados


    }

    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber){
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long inputNumber){
            BigInteger tempResult = BigInteger.ONE;

            for (long i = inputNumber; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            };

            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
