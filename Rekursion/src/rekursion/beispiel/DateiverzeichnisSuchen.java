package rekursion.beispiel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DateiverzeichnisSuchen {
    public static void main(String[] args) {
        DateiverzeichnisSuchen dvs = new DateiverzeichnisSuchen();
        String pathname = "C:\\Users\\User\\Desktop\\Studium-OTH\\Lernplan\\Semester-4\\Java_AD_Kurs\\Code_AD\\Rekursion\\Datenverzeichnis";


        File fileDirectory = new File(pathname);

        ArrayList<File> files = dvs.getPaths(fileDirectory, new ArrayList<File>());

            try {
                for (int i = 0; i < files.size(); i++) {
                    System.out.println("File: " + files.get(i).getCanonicalPath());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println(System.lineSeparator());


            // Suchen
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your search input: ");
        String userSearchInput = sc.next();
            for(int i = 0; i < files.size(); i++) {
                if (i != files.size() - 1) {
                    if (files.get(i).getName().equalsIgnoreCase(userSearchInput + ".txt")) {
                        System.out.println("Found: " + files.get(i).getName());
                        break;
                    }
                } else {
                    if (files.get(i).getName().equalsIgnoreCase(userSearchInput + ".txt")) {
                        System.out.println("Found: " + files.get(i).getName());
                    } else {
                        System.out.println("File not found!");
                    }
                }
            }
    }

    public ArrayList<File> getPaths(File file, ArrayList<File> list) {
        if(file == null || list == null || !file.isDirectory()) {
            return null;
        }
        File[] files = file.listFiles();
        for(File file2 : files) {
            if(file2.isDirectory()) {
                getPaths(file2, list); // Rekursion
            }
            list.add(file2);
        }
        return list;
    }
}
