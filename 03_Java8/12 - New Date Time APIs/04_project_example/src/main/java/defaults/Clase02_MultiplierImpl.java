package defaults;

import java.util.List;

public class Clase02_MultiplierImpl implements Clase02_Multiplier{

    //Prior Java 8
    @Override
    public int multiply(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (x, y) -> x*y);
    }


    public int size(List<Integer> integerList){
        System.out.println("HOLA DESDE LA IMPLEMENTACION DE MULTIPLIER");
        return integerList.size();
    }
}
