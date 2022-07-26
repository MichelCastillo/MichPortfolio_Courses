package Clase00_BasicGenerics;

public class GenericMethod {
    /*
    public void  showItem(T item){
        ...
    }
    Así como está no funciona, ya que tenemos que declarar de que estamos usando GENERICS
    */

    public <T> void showItem(T item) {
        System.out.println("Generic item: " + item.toString());
    }

    public <T> T returnItem(T item) {
        return item;
    }

    // Method with 2 Generic Paramethers
    public <T, V> void printItems(T tItem, V vItem) {
        System.out.println(tItem.toString());
        System.out.println(vItem.toString());
    }

    // One dimensional array with Generic Items
    public <T> void showItems(T[] items){
        for (T t:
             items) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        GenericMethod method = new GenericMethod();
        //method.showItem(34.5);

        // Method with 2 Generic Paramethers
        method.printItems("Parámetro 1", 2);

        // One dimensional array with Generic Items
        Integer[] numeros = {1,2,5,4,3}; //no podemos usar int, ya que Integer es la representación de los objetos Enteros
        method.showItems(numeros);

        String[] nombres = {"Mich", "Nacho", "Agustin"};
        method.showItems(nombres);

    }
}
