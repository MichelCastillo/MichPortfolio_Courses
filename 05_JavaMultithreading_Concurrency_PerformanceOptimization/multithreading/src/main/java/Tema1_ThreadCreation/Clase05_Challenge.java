package Tema1_ThreadCreation;

import java.util.ArrayList;
import java.util.List;

public class Clase05_Challenge{

    // Add any necessary member variables here
    private List<Runnable> tasks = new ArrayList<>();

    /*
     * @param tasks to executed concurrently
     */
    public Clase05_Challenge(List<Runnable> tasks) {
        // Complete your code here
        this.tasks.addAll(tasks);

    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        this.tasks.forEach(task -> new Thread(task).start());
    }
}
