import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVSDeclarativeExample2 {
    
    public static void main(String[] args) {
        
        // Ejemplo 2: Remover los duplicados de una lista
        List<Integer> integerList = Arrays.asList(1,2,3,3,4,4,5,5,6,6,7,7,8,8,9,10);

        // Imperative way
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer integer : integerList) {
            if (!uniqueList.contains(integer)){ //Preguntamos si mi listaUnica no tiene ese valor
                uniqueList.add(integer);        //Caso positivo (no tiene ese valor) lo agregamos al segundo array
            }
        }

        //Imprimimos la lista
        System.out.println("Imperative Unique list: " + uniqueList);

        // Declarative way
        List<Integer> uniqueListDeclarative = integerList.stream() //declaramos que arrancamos con un stream
                                                .distinct()     //Sacamos los repetidos
                                                .collect(Collectors.toList());

        System.out.println("Declarative Unique List: " + uniqueListDeclarative);

    }

}
