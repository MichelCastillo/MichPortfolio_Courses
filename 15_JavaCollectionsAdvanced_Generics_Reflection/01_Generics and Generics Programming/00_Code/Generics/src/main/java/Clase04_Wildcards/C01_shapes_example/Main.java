package Clase04_Wildcards.C01_shapes_example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void drawAll(List<Shape> shapes){
        for (Shape shape :
             shapes) {
            shape.draw();
        }
    }

    public static void drawAllCorrect1(List<? extends Shape> shapes){
        for (Shape shape :
                shapes) {
            shape.draw();
        }
    }

    /*
    * <T extends Shape> -> bounded type parameter
    * <? super> -> wildcard parameter
    * */
    public static <T extends Shape> void drawAllCorrect2(List<T> shapes){
        for (Shape shape :
                shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        /*drawAll(rectangles); //Espera una lista de SHAPES no de RECTANGLES*/
        drawAllCorrect1(rectangles);


    }
}
