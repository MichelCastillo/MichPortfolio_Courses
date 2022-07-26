package Clase01_BoundedGenericTypes;

public class C01_Exercise {

    //El objetivo de este ejemplo, es construir un método que pueda sumar cualquier tipo de número

    public static <T extends Number> double add(T num1, T num2){ //usamos double por ser el más grande
        return num1.doubleValue() + num2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(add(19.5, 20));
    }

}
