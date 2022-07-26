package Clase00_BasicGenerics;

public class App {

    public static void add (int num1, int num2){

        int result = num1 + num2;

        System.out.println("Result is " + result);
    }

    // Method soverloading
    public static void add (double num1, double num2){

        double result = num1 + num2;

        System.out.println("Result is " + result);
    }

    static class Store<T>{ //Agreagmos el T type

        private T item;
        //Con object, al ser Padre de todos, podemos meter todo tipo de objeto numerico dentro

        public void setItem (T item){
            this.item = item;
        }

        public T getItem(){
            return this.item;
        }

    }

    //Creando tipos Genéricos multiples
    static class Hashtable<K, V>{

        private K key;
        private V value;

        public Hashtable(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Hashtable{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {

        //add(10.4, 5.2); //Error dado que solo acepta enteros
        //Para solucionarlo, creamos otro metodo cone se tipo de valores

        //Store store = new Store();
        //store.setItem(45);
        //Integer item = (Integer) store.getItem(); //Type casting - we can cast Object into any other object

        //System.out.println(item);
        //Con este approach, la JVM de Java debe testear el type casting en tiempo de ejecución
        //Además con este approach, si o si debemos castear.


        ///////////////////////////////////////////
        //Raw type -> Con esto, transformamos run time errors a compile errors
        /*
        * <> -> Diamond Operator
        * Podemos usar algo como esto:
        * Store store = new Store(); -> No va a haber un error de compilación, pero java nos va a avisar de que esto se trata de un raw type, y que asumirá que es T
        *   Por esto, vamos a tener que volver a castear
        *
        * */
/*
        Store<Integer> store = new Store<>();
        store.setItem(45);
        Integer item = store.getItem();
        System.out.println(item);
*/

        Hashtable<Integer, Integer> hasTable = new Hashtable<>(23, 23);
        System.out.println(hasTable);
    }

}
