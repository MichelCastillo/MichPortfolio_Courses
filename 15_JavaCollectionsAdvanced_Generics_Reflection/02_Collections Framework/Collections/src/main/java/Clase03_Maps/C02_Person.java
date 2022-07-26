package Clase03_Maps;

import java.util.Objects;

public class C02_Person {

    private String name;
    private int age;

    public C02_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    // because in a hashmap it may happen collisions
    // that we have to find the item (Person) in a linked list
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C02_Person that = (C02_Person) o;
        return age == that.age && name.equals(that.name);
    }

    // hashCode == hash-function -> find a valid index of the underlying one-dimensional array
    // it calculates an array index based on the key (keys == Person objects)
    // avoid clustering with prime numbers
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // THERE ARE SOME RULES
    // 1.) If two objects are equal, then they must have the same hash code
    // 2.) if two objects have the same hash code they may or may not be equal

    @Override
    public String toString() {
        return "C02_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
