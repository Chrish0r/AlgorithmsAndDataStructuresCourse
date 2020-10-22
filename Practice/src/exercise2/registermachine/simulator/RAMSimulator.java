package exercise2.registermachine.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RAMSimulator {

    public static void main(String[] args) {
        File ramFile = new File("C:\\Users\\User\\Desktop\\Studium-OTH\\Lernplan\\Semester-4\\Algorithmen und Datenstukturen\\Übungen\\Blatt2\\Abgabe_Blatt2\\Aufgabe1\\RAM.txt");

        List<String> fileContent = extractStringFromFile(ramFile);

        // simulating ram
        for(String line : fileContent) {
            switch(line) {
              //  case "N DD 0h ":
                   // Scanner sc = new Scanner(System.in);
                  //  System.out.println("Please enter 'n' as your upper bound:");
                 //   int n = sc.nextInt();
                   // break;

              //  case "SUM DD 0h":
                   // int sum = 0;
                //    break;

                case "; RECHNEN":
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter 'n' as your upper bound:");
                    int n = sc.nextInt();
                    int sum = 0;

                    for(int i = n; i > 0; i--) {
                        sum += i;
                    }
                    System.out.println(sum);
                    break;

               // case "PRINT_DEC 4, [SUM]":
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
}
