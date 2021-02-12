package exercise11.task1.breitensuche;

public class Matrix {
    private int[][] arr;

    public Matrix(int amountNodes) {
        arr = new int[amountNodes][amountNodes];
    }

    public void createAdjMat(int[][] arr) {
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][6] = 1;

        arr[1][3] = 1;

        arr[2][0] = 1;
        arr[2][3] = 1;
        arr[2][4] = 1;

        arr[3][6] = 1;

        arr[4][0] = 1;
        arr[4][5] = 1;
        arr[4][8] = 1;

        arr[5][2] = 1;
        arr[5][3] = 1;
        arr[5][4] = 1;
        arr[5][7] = 1;

        arr[6][7] = 1;

        arr[7][3] = 1;
        arr[7][8] = 1;

        arr[8][5] = 1;
    }

    public void printMat(int[][] arr) {
        int numRows = arr.length;
        int numCols = arr[0].length;

        // print column-numbers
        for(int i = 0; i < numRows; i++) {
           if(i == 0) {
               System.out.print(" | " + i + "  ");
           }
           else if(i == numRows-1) {
               System.out.println(i);
           } else {
               System.out.print(i + "  ");
           }
        }
        System.out.println("-----------------------------");

        for(int i = 0; i < numRows; i++) {
            System.out.print(i + "| ");
          for(int j = 0; j < numCols; j++) {
              System.out.print(arr[i][j] + "  ");
          }
            System.out.println();
        }
    }

    //--------------------getters and setters----------------------------
    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }
}
