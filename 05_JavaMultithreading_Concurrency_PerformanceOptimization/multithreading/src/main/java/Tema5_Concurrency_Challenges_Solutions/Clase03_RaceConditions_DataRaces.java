package Tema5_Concurrency_Challenges_Solutions;

public class Clase03_RaceConditions_DataRaces {

    /*
    Race Condition:
        - Condition when multiple threads are accessing a shared resource
        - At least one thread is modifying the resource
        - The timming of threads scheduling may cause incorrect results
        - The core of the problem is non-atomic operations performed on the shared resource

    Solution:
        - Identification of the critical section where the race condition is happening
        - Protection of the critical section by a synchronized block
    */

    /*
        DataRace - Example

        public class ShraedClass{
        int x = 0, y = 0;

        public void increment(){
            y++;
            x++;
        }

        public void checkForDataRace(){
            if (y > x) {
                throw new DataRaceException("This should not be possible");
            }
        }
    }

    Problem:
        - Compiler and CPU may execute the instructions OUT OF ORDER to optimize performance and utilization
        - They will do so while maintaining the logical correctness of the code
        - Out of Order execution by the compiler and CPU are important features to speed up the code.
        - The compiler re-arranges instructions for beter:
            - Branch predication
            - Vectorization - parallel instruction execution (SIMD)
            - Prefetching instructions - better cache performance
        - CPU re-arrenges instructions for better hardware units utilization

        public void someFunction(){
            x = 1;
            y = x + 2;
            z = y + 10;
        } -> Esta funcion no se va a ejecutar en cualquier orden ya que cada linea depende de la anterior

        En los siguientes casos, si representaria un problema, dado que para el compilador ambos métodos son equivalentes.
        Por lo que en un entorno multithreading sería un problema
        public void increment1(){
            x++;
            y++;
        }

        public void increment1(){
            y++;
            x++;
        }

        Consequences:
            - May lead to unexpected, paradoxical and incorrect results

        Solutions:
            - Establish a Happens - Before semantics by one of these methods:
                - Synchronization of methods which modify shared variables (Con esta solución, un solo thread va a tener acceso a una variable en todo momento)
                - Declaration of shared variables with the volatile keyword
                    private volatile int sharedVar;

                    public void method(){
                        ...//All instructions will be executed before
                        read/write(sharedVar);
                        ...//All instructions will be executed after
                    }

     */

    public static void main(String[] args) {
        ShraedClass shraedClass = new ShraedClass();

        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < Integer.MAX_VALUE ; i++){
                shraedClass.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < Integer.MAX_VALUE ; i++){
                shraedClass.checkForDataRace();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static class ShraedClass{
        private volatile int x = 0; //agregamos volatile
        private volatile int y = 0;

        public void increment(){
            x++;
            y++;

        }

        public void checkForDataRace(){
            if (y > x) {
                System.out.println("This should not be possible - y > x - Data Race detected - X: " + x + " - Y: " + y);
            }
        }


    }
}
