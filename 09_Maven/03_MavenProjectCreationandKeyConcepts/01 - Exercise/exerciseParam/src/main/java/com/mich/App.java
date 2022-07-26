package com.mich;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to the Java Exercise 1: Sum of parameters");

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        Integer value1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        Integer value2 = scanner.nextInt();

        try {
            System.out.println("Procesando...");
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
            // TODO Auto-generated catch block
        }
        
        System.out.println("Resultado de la suma: " + sum(value1, value2));
    }

    public static Integer sum(Integer value1, Integer value2){
        return value1 + value2;
    }
}
