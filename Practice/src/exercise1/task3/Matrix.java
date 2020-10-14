package exercise1.task3;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private  int[][] array2D;
    int row;
    int col;

    public Matrix(int m, int n) { // m -> rows; n -> columns
        array2D = new int[m][n];
    }

    public Matrix(int[][] array2D) {
        this.array2D = array2D;
    }

    public static void main(String[] args) {
       // Matrix matrix = new Matrix(4, 3);
        Matrix matrix = new Matrix(2, 2);

        // creating 2nd matrix to test/use add- and mult-functionality
        /*


         int[][] arrMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
        };

         */
        int[][] arrMatrix2 = {
                {3, 2},
                {0, 1}
        };
        Matrix matrix2 = new Matrix(arrMatrix2);

        int[][] arrMatrix3 = {
                {1, 3},
                {2, 0}
        };
        Matrix matrix3 = new Matrix(arrMatrix3);

        // Init()
        matrix.init(matrix.array2D);
        System.out.println("initialized matrix:");
        matrix.print(matrix.array2D);

        // Input()
        /*
        matrix.input(matrix.array2D);
        System.out.println("Matrix created trough manual input:");
        matrix.print(matrix.array2D);

         */

        // Random()
        matrix.randomFill(matrix.array2D);
        System.out.println("Matrix created trough randomized input:");
        matrix.print(matrix.array2D);

        // Add()
       // int[][] sumMatArr = matrix.add(matrix2.array2D);

        Matrix matrixSum = new Matrix(2, 2);
        matrixSum.init(matrixSum.array2D);

        matrixSum.add(arrMatrix2, arrMatrix3);
        System.out.println("the resulted matrix of the two added matrices is:");
        matrixSum.print(matrixSum.array2D);
    }

    //---------------------------logic/operations-------------------------------
          // Init()
    public void init(int[][] arrMatrix) {
        for(int row = 0; row < arrMatrix.length; row++) {
            for(int col = 0; col < arrMatrix[row].length; col++) {
                arrMatrix[row][col] = 0;
            }
        }
    }
         // print()
    public void print(int[][] arrMatrix) { // Note: could be done nicer (more even) with StringBuilder()
        for(int row = 0; row < arrMatrix.length; row++) {
            for(int col = 0; col < arrMatrix[row].length; col++) {
                if(col == arrMatrix[row].length - 1) {
                    System.out.println(arrMatrix[row][col]);
                    break;
                }
                System.out.print(arrMatrix[row][col] + ", ");
            }
        }
        System.out.println();
    }
       // input()
    public void input(int[][] arrMatrix) {
        Scanner sc = new Scanner(System.in);

        for(int row = 0; row < arrMatrix.length; row++) {
            for(int col = 0; col < arrMatrix[row].length; col++) {
                System.out.println("Please enter one value for the matrix located in row " + row + " and in column " + col + ":");
                arrMatrix[row][col] = sc.nextInt();
            }
        }
    }
       // randomFill()
    public void randomFill(int[][] arrMatrix) {

        for(int row = 0; row < arrMatrix.length; row++) {
            Random rn = new Random();
            for(int col = 0; col < arrMatrix[row].length; col++) {
                arrMatrix[row][col] = rn.nextInt();
            }
        }
    }

    // add()
    public void add(int[][] arrMat2, int[][] arrMat3) {
        for(int row = 0; row < this.array2D.length; row++) {
            for(int col = 0; col < this.array2D[row].length; col++) {
                this.array2D[row][col] = arrMat2[row][col] + arrMat3[row][col];
            }
        }
    }

    //------------------------- getters and setters---------------------------------------
    public int[][] getArray2D() {
        return array2D;
    }

    public void setArray2D(int[][] array2D) {
        this.array2D = array2D;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
