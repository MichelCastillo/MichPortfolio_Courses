package lambdas;

import javax.sound.sampled.SourceDataLine;

public class RunnableLambdaExample implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {
        // Prior Java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable prior Java 8");
            }
        };

        new Thread(runnable).start();
    }
}

