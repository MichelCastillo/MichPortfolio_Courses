package Clase03_TypeReference;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static <T> void addStore(T t, List<Bucket<T>> list){
        Bucket<T> bucket = new Bucket<>();

        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list...");
    }

    public static void main(String[] args) {

        List<Bucket<String>> list = new ArrayList<>();

        App.addStore("Adam", list);

        //Podemos especificar que podemos agregar strings a la Lista, con esto el compilador no tiene que suponer el tipo mas concreto (type witness)
        App.<String>addStore("Daniel", list);
        list.forEach(System.out::println);


    }
}

class Bucket<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "item=" + item +
                '}';
    }
}
