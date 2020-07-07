package ru.nsd.islandcount;

import ru.nsd.islandcount.objects.Graph;
import ru.nsd.islandcount.objects.Matrix;

public class Main {
    public static void main(String[] args) throws Exception {
        Matrix matrix = new Matrix();
        System.out.println(matrix.toString());
        Graph graph = new Graph(matrix);
        System.out.println(graph.quantityOfIslands(graph)- matrix.quantityOfDots());
    }
}
