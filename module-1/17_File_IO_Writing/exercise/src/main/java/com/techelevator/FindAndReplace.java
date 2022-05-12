package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter search word: ");
        String searchWord = scanner.nextLine();

        if (searchWord == null || searchWord.isEmpty()) {
            System.out.println("Search word is empty");
            System.exit(1);
        }

        System.out.println("Enter replacement word: ");
        String replace = scanner.nextLine();

        if (replace == null || replace.isEmpty()) {
            System.out.println("No replacement word");
            System.exit(1);
        }

        System.out.println("Enter input file: ");
        String input = scanner.nextLine();
        File inputFile = new File(input);

        if (!inputFile.exists()) {
            System.out.println("No input file");
            System.exit(1);
        }

        System.out.println("Enter output file: ");
        String output = scanner.nextLine();
        File outputFile = new File(output);

        if (!outputFile.exists()) {
            System.out.println("No output file");
            System.exit(0);
        }

        try (PrintWriter pw = new PrintWriter(outputFile)) {
            Scanner inputScanner = new Scanner(inputFile);
            while (inputScanner.hasNextLine()) {

                String lineOfOldFile = inputScanner.nextLine();
                String lineOfNewFile = lineOfOldFile.replace(searchWord, replace);
                pw.println(lineOfNewFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

}
