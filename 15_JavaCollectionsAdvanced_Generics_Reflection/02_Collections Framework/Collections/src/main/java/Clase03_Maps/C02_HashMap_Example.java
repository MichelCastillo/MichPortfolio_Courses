package Clase03_Maps;

import java.util.HashMap;
import java.util.Map;

public class C02_HashMap_Example {

    public static void main(String[] args) {

        Map<String, C02_Person> map = new HashMap<>();

        map.put("Adam", new C02_Person("Mich", 25));

    }

}
