package Clase05_TypeErasure;

public class C01_BridgeMethods {

    /*Bridge methods are usually occur when inheritance is used
     - it is an additional method added during type erasure in order to avoid ambiguous situations*/

    //-------------------------- BEFORE TYPE ERASURE --------------------------

    /*class Node<T>{
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    class MyNode extends Node<Integer>{

        public MyNode(Integer data) {
            super(data);
        }

        public void setData(Integer data){
            super.setData(data);
        }
    }*/

    //-------------------------- AFTER TYPE ERASURE --------------------------

    /*As we can see here, the setData() method arguments do not match. Java compiler will create a method in order to solve this problem.
            This is the bridge method*/

    /*class Node{
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    class MyNode extends Node{

        public MyNode(Integer data) {
            super(data);
        }

        public void setData(Integer data){
            super.setData(data);
        }
    }

    //-------------------------- BRIDGE METHOD CREATION --------------------------

    class MyNode extends Node<Integer>{

        public MyNode(Integer data) {
            super(data);
        }

        public void setData(Object o){
            setData((Integer) o);       <------------ BRIDGE METHOD
        }

        public void setData(Integer data){
            super.setData(data);
        }
    }

    */
}
