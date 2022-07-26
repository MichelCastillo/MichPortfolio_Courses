package Clase05_TypeErasure;

import java.util.ArrayList;

public class C00_TypeErasure {

    /*In order to implement generics, Java uses type erasure:
        - Replace all type parameters in generic types with their bounds or Object
            if the type parameters are unbounded. So the final bytecode will contain plain java objects/classes

        - uses type cast if necessary
        - sometimes it generates extra methods: the so called "bridge methods" in order to maintain polymorphism with generic types


        In the byte code, the following code is equivalent:
            List<Integer> list = new ArrayList<>();
            list.add(3);
            Integer num = list.get(0);

            -----------------------------------------------------
            List list = new ArrayList<>();
            list.add(3);
            Integer num = (Integer) list.get(0);*/

    public static void main(String[] args) {

        FirstStore fs = new FirstStore();
        fs.setItem(new String());
        fs.setItem(new Double(23));

        System.out.println(fs.getItem());
    }

}

//Creamos una clase que puede almacenar cualquier tipo de objeto - esto va a ser transformado en una clase que en vez de T, tenga Object
// En cambio si implementamos class FirstStore <T extends Serializable>, va a ser reemplazado por Serializable

class FirstStore<T>{
    private T item;

    public T getItem(){
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

