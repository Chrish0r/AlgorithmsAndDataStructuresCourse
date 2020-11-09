package exercise2.registermachine.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RAMSimulator {
    private int n;
    private int sum;



    public static void main(String[] args) {
        File ramFile = new File("C:\\Users\\User\\Desktop\\Studium-OTH\\Lernplan\\Semester-4\\Algorithmen und Datenstukturen\\Übungen\\Blatt2\\Abgabe_Blatt2\\Aufgabe1\\RAM.txt");
        RAMSimulator o = new RAMSimulator();

        List<String> fileContent = extractStringFromFile(ramFile);


        // simulating ram
        for(String line : fileContent) {
            switch(line) {
                  case "N DD 0h  ":
                      Scanner sc = new Scanner(System.in);
                      System.out.println("Please enter 'n' as your upper bound:");
                      o.setN(sc.nextInt());
                      break;

                  case "SUM DD 0h":
                    o.setSum(0);
                     break;

                case "; RECHNEN":

                    for(int i = o.getN(); i >= 0; i--) {
                        o.setSum(o.getSum() + i);
                      //  o.setSum((int) (o.getSum() + Math.pow(2,i))); // if sum(2^i)
                    }
                    break;

                 case "PRINT_DEC 4, [SUM]     ":
                     System.out.println(o.getSum());
                     break;

                case "ret        ":
                    break;
            }
        }
    }

    public static List<String> extractStringFromFile(File ramFile) {
        List<String> content = new ArrayList<String>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(ramFile))) {
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
