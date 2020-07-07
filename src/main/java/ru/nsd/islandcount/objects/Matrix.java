package ru.nsd.islandcount.objects;

import ru.nsd.islandcount.objectsinitializers.MatrixInitializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix{
    private int n;
    private int m;
    private char[][] arrayMatrix;
    private MatrixInitializer matrixInitializer = new MatrixInitializer();

   public Matrix() {
       try {
           InputStream inputStream = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\WebProject\\src\\main\\resources\\input.txt");
           matrixInitializer.matrixInitialize(inputStream, this);
       }catch (Exception ex){

       }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setArrayMatrix(char[][] arrayMatrix) {
        this.arrayMatrix = arrayMatrix;
    }

    public char[][] getArrayMatrix() {
        return arrayMatrix;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(arrayMatrix[i][j]);
                if(j == (m - 1)){
                    //sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public char[] toOneDimensionalArray(char[][] arrayMatrix){
        char[] arr = new char[n*m];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k] = arrayMatrix[i][j];
                k++;
            }
        }
        return arr;
    }

    public int quantityOfDots(){
        int quantityOfDots = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arrayMatrix[i][j] == '.'){
                    quantityOfDots++;
                }
            }
        }
        return quantityOfDots;
    }

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