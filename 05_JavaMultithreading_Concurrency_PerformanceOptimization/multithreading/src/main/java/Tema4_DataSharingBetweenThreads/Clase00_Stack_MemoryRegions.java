package Tema4_DataSharingBetweenThreads;

public class Clase00_Stack_MemoryRegions {

    /*Stack: memory region where

        - Methods are called
        - Arguments are passed
        - Local variables are stored

    Properties:
        - All variables belong to the thread execution on that stack
        - Statically allocated when the thread is created
        - The stack's size is fixed, and relatively small (platform specific).
        - If our calling hierarchy is too deep. We way get an StackOverflowException. (Risky with recursive calls)

     */

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        //esta asignación de variables ocurre dentro del mismo frame, el primero que se crea.
        int result = sum(x, y); //esta operacion necesita de la creación de un nuevo frame, dado que la asignación de result, queda esperando la
                                //ejecución del método sum
                                //Una vez que termina este método, ese nuevo frame se elimina, y se reanuda con este. (Se van apilando)
    }

    private static int sum(int x, int y){
        int s = x + y;
        return s;
    }
}
