package Clase06_GenericsFinalTask;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Algorithm> {
    private List<T> algorithms;
    // Con esto decimos que esta clase va a manejar clases que implementen Algorithm

    public Library() {
        this.algorithms = new ArrayList<>();
    }

    public void add(T algorithm){
        this.algorithms.add(algorithm);
    }

    public T getLast(){
        if (this.algorithms.size() < 1) return null;
        return algorithms.remove(algorithms.size() - 1);
    }
}
