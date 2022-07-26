package Clase01_JavaGenerics;

import java.util.ArrayList;

public class Clase00_GenericsOverview {



    public static void main(String[] args) {
        String[] strArray = new String[20];
        Employee[] empArray = new Employee[20];

        strArray[0] = "Meenal";
        //strArray[1] = new Employee(); //No se puede dado que es String

        //Usando ArrayList
        ArrayList l = new ArrayList(); //No necesita que le declarmeos el tamaño

        //Usando int --> Integer
        l.add("Meenal");
        l.add(new Employee());
        String name = (String) l.get(0); //No se puede sin casteo

    }

}
