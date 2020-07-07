package ru.nsd.islandcount.objectsinitializers;

import ru.nsd.islandcount.objects.Graph;
import ru.nsd.islandcount.objects.Matrix;

public class GraphInitializer {
    public void graphInitialize(Graph graph, Matrix matrix) {
        graph.setN(matrix.getN() * matrix.getM());
        graph.setArrayGraph(new char[graph.getN()][graph.getN()]);
        graph.setNumberOfConnectedComponent(new int[graph.getN()]);
        fillGraph(graph, matrix, matrix.getN(), matrix.getM());
    }

    private void fillGraphMiddlePartOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m){
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }



    }

    private void fillGraphFirstRowOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m){
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
            }
            if(n > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                    graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                    graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }

    private void fillGraphLastRowOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }

    private void fillGraphFirstColumnOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {
                    graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                    graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }


    private void fillGraphLeftUpAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {////////////////+++++++++++
                    graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                    graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if(n > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                    graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                    graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }
    private void fillGraphRightUpAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                    graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                    graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
                }
            }
            if(n > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                    graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                    graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }

    private void fillGraphLeftDownAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j + 1]) {
                    graph.getArrayGraph()[i * m + j][i * m + (j + 1)] = '1';
                    graph.getArrayGraph()[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }

    private void fillGraphRightDownAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }


    private void fillGraphLastColumnOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.getArrayMatrix()[i][j] == '#') {
            graph.getArrayGraph()[i * m + j][i * m + j] = '1';
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i][j - 1]) {
                graph.getArrayGraph()[i * m + j][i * m + (j - 1)] = '1';
                graph.getArrayGraph()[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i + 1][j]) {
                graph.getArrayGraph()[i * m + j][(i + 1) * m + j] = '1';
                graph.getArrayGraph()[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.getArrayMatrix()[i][j] == matrix.getArrayMatrix()[i - 1][j]) {
                graph.getArrayGraph()[i * m + j][(i - 1) * m + j] = '1';
                graph.getArrayGraph()[(i - 1) * m + j][i * m + j] = '1';
            }
        }

    }

    public void fillGraph(Graph graph, Matrix matrix, int n, int m) {
        for (int i = 0; i < graph.getN(); i++) {
            for (int j = 0; j < graph.getN(); j++) {
                graph.getArrayGraph()[i][j] = '0';
            }
        }
        if(n >= 1 && m >= 1){

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i >= 1 && i <= n - 2) && (j >= 1 && j <= m - 2)) {
                    fillGraphMiddlePartOfMatrix(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && (j >= 1 && j <= m - 2)) {
                    fillGraphFirstRowOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && (j >= 1 && j <= m - 2)){
                    fillGraphLastRowOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if((j == 0) && (i >= 1 && i <= n - 2)){
                    fillGraphFirstColumnOfMatrixWithoutFirstAndLast(graph,matrix, i, j, n, m);
                }
                else if((j == (m - 1)) && (i >= 1 && i <= n - 2)){
                    fillGraphLastColumnOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && j == 0){
                    fillGraphLeftUpAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && j == m - 1){
                    fillGraphRightUpAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && j == 0){
                    fillGraphLeftDownAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && (j == (m - 1))){
                    fillGraphRightDownAngleOfMatrix(graph, matrix, i, j, n, m);
                }
            }
        }
    }

}
