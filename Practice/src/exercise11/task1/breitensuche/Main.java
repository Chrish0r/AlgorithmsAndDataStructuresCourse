package exercise11.task1.breitensuche;

public class Main {

    public static void main(String[] args) {
        Matrix adjMatrix = new Matrix(9);

        adjMatrix.createAdjMat(adjMatrix.getArr());

        adjMatrix.printMat(adjMatrix.getArr());
    }
}
