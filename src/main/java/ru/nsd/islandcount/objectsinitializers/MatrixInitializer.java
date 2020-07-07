package ru.nsd.islandcount.objectsinitializers;

import ru.nsd.islandcount.objects.Matrix;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixInitializer {

    public void matrixInitialize(InputStream fileStream, Matrix matrix) throws InputMismatchException, IOException {
        Scanner sc = new Scanner(fileStream);
        matrix.setN(sc.nextInt());
        matrix.setM(sc.nextInt());
        sc.nextLine();
        matrix.setArrayMatrix(new char[matrix.getN()][matrix.getM()]);
        for (int i = 0; i < matrix.getN(); i++) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            System.arraycopy(arr, 0, matrix.getArrayMatrix()[i], 0, arr.length);
        }
    }
}