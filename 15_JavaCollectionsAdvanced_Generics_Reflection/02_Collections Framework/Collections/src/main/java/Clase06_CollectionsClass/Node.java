package Clase06_CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {

    private List<Node> neighbors;

    public Node() {
        this.neighbors = new ArrayList<>();
    }

    // Para hacerlo inmutable

    public List<Node> getNeighbors() {
        return Collections.unmodifiableList(this.neighbors);
    }
}
