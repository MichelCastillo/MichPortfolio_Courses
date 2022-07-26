package Tema1_ThreadCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clase04_Exercise_Police {
    public static final int MAX_PASSWORD = 999;
    public static void main(String[] args) {

        //Creamos una clase random para generar la clave
        Random random = new Random();

        //Creamos el cofre con la clave
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        //Creamos una lista de threads
        List<Thread> threads = new ArrayList<>();

        //Agregamos nustros threads
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        //Ejecutamos todos los threads para ver si algun hacker adivina la pwd o los atrapa el policia
        for (Thread t: threads
             ) {
            t.start();
        }
    }

    //Creamos el cofre donde vamos a guardar nuestro dinero
    private static class Vault{
        private int password;

        public Vault(int passoword){
            this.password = passoword;
        }

        public boolean isCorrectPassword(int guess){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored){

            }
            return this.password == guess;
        }
    }

    //Creamos una clase abstracta que va a encapsular la funcionalidad de todos los hackers
    private static abstract class HackerThread extends Thread{
        protected Vault vault;

        public HackerThread(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start(){
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    //Creando el primer hacker
    private static class AscendingHackerThread extends HackerThread{
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            //Con este metodo vamos a tratar de adivinar la password
            for (int guess = 0; guess < MAX_PASSWORD ; guess++){
                if (vault.isCorrectPassword(guess)){ //Si se cumple, adivinamos la password
                    System.out.println(this.getName() + " guessed the password: " + guess);
                    System.exit(0);
                }
            }
        }
    }

    //Creando el segundo hacker
    private static class DescendingHackerThread extends HackerThread{

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD ; guess >= 0; guess--){
                if (vault.isCorrectPassword(guess)){
                    System.out.println(this.getName() + " guessed the password: " + guess);
                    System.exit(0);
                }
            }
        }
    }

    //Creando el policía
    public static class PoliceThread extends Thread{
        @Override
        public void run() {
            for (int i = 10; i > 0; i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Police count: " + i);
            }

            System.out.println("Game over for you hackers...");
            System.exit(0);
        }
    }
}
