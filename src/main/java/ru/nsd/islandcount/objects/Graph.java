package ru.nsd.islandcount.objects;

import ru.nsd.islandcount.objectsinitializers.GraphInitializer;

import java.util.ArrayList;

public class Graph {

    public int n;
    public char[][] arrayGraph;
    public int[] numberOfConnectedComponent;
    private GraphInitializer graphInitializer = new GraphInitializer();


    public Graph(Matrix matrix) {
        this.n = matrix.getN() * matrix.getM();
        arrayGraph = new char[n][n];
        numberOfConnectedComponent = new int[n];
        for (int i = 0; i < numberOfConnectedComponent.length; i++) {
            numberOfConnectedComponent[i] = 0;
        }
        graphInitializer.graphInitialize(this, matrix);

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public char[][] getArrayGraph() {
        return arrayGraph;
    }

    public void setArrayGraph(char[][] arrayGraph) {
        this.arrayGraph = arrayGraph;
    }

    public void setNumberOfConnectedComponent(int[] numberOfConnectedComponent) {
        this.numberOfConnectedComponent = numberOfConnectedComponent;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arrayGraph[i][j]);
               /* if(j == (n - 1)){
                    sb.append('\n');
                }*/
            }
        }
        return sb.toString();
    }

    public char[] toOneDimensionalArray(char[][] arrayGraph) {
        char[] arr = new char[n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[k] = arrayGraph[i][j];
                k++;
            }
        }
        return arr;
    }

    public int quantityOfIslands(Graph graph) {
        ArrayList<Island> islands = new ArrayList<>();
        int quantityOfConnectedComponent = 0;
        for (int i = 0; i < graph.n; i++) {
            Island island;
            if (numberOfConnectedComponent[i] == 0) {
                island = new Island();
                quantityOfConnectedComponent++;
                dfs(i, quantityOfConnectedComponent, island);
                islands.add(island);
            }
        }

        return islands.size();
    }

    public void dfs(int i, int quantity, Island island) {
        island.add(i);
        numberOfConnectedComponent[i] = quantity;
        for (int j = 0; j < arrayGraph.length; j++) {
            if (arrayGraph[i][j] == '1' && numberOfConnectedComponent[j] == 0) {
                dfs(j, quantity, island);
            }
        }
    }

}