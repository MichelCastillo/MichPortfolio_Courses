package defaults;

import java.util.List;

public interface Clase02_Multiplier {

    //Prior Java 8
    int multiply(List<Integer> integerList);

    //Java 8 - default - pueden ser sobreescritos por las implementaciones
    default int size(List<Integer> integerList){
        System.out.println("HOLA DESDE LA INTERFAZ MULTIPLIER");
        return integerList.size();
    }

    //Java 8 - static - NO PUEDEN ser sobreescritos por las implementaciones
    static boolean isEmpty(List<Integer> integerList){
        return integerList != null && integerList.size() > 0;
    }
}
