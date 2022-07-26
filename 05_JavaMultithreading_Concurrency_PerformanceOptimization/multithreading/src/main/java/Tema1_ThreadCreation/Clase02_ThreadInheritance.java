package Tema1_ThreadCreation;

public class Clase02_ThreadInheritance {

    public static void main(String[] args) {

        //Existen 2 formas de crear threads

        //Forma 1: Creando un objeto thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("THREAD CREATED AS OBJECT");
                System.out.println("Hola desde: " + Thread.currentThread().getName());
            }
        });

        thread.start();

        //Creando desde la clase
        Thread threadClass = new NewThread();
        threadClass.start();
    }

    //Forma 2: Usando una clase que extienda de Thread (que implementa Runnable)
    private static class NewThread extends Thread{
        @Override
        public void run(){
            this.setName("THREAD CREATED IN A CLASS");
            System.out.println("Hola desde (class implementation): " + this.getName());
        }
    }
}
