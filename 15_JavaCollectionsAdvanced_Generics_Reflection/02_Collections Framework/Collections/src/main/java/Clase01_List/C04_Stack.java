package Clase01_List;

import java.util.Stack;

public class C04_Stack<T> extends Stack<T> {

    Stack<T> stack = new Stack<>();

    @Override
    public T push(T item) {
        if (stack.stream().noneMatch(e -> e.equals(item))){
             return stack.push(item);
        }
        return null;
    }

    @Override
    public String toString() {
        return "C04_Stack{" + stack.toString() +
                '}';
    }

    public static void main(String[] args) {

        C04_Stack<Integer> s = new C04_Stack<>();

        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.push(3));
        System.out.println(s.push(1));

        System.out.println(s.toString());

        Stack<String> names = new Stack<>();
        names.add("Mich");
        names.add("Ignacio");
        names.add("Agus");

        //peek
        System.out.println(names.peek()); //last item added - no elimina el head

        //isEmpty
        while (!names.isEmpty()){
            System.out.println(names.pop()); //last item added - lo elimina
        }


    }
}
