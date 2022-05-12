package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Where is the input file (please include the path to the file)? [path-to-file]/input.txt: ");
        String inputPath = inputScanner.nextLine();

        File inputFile = new File(inputPath);
        String fileName = inputFile.getName();

        String txtPart = fileName.substring(fileName.length() - 4);
        String namePart = fileName.substring(0, fileName.length() - 4);

        if (inputFile.exists() == false) {
            System.out.println("File does not exist");
        } else if (inputFile.isFile() == false) {
            System.out.println("Not a file");
        }

        System.out.println("How many lines of text (max) should there be in the split files: ");
        String maxInput = inputScanner.nextLine();
        int maxLines = Integer.parseInt(maxInput);


        if (maxInput == null || maxInput.equals("")) {
            System.out.println("Invalid input");
            System.exit(1);
        }

        int lineCount = 1;
        List<String> lineList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                lineList.add(line);
                lineCount++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The input file has " + lineCount + " lines of text");
        System.out.println("");

        int numFiles = (int) Math.ceil(lineCount / maxLines);

        System.out.println("The " + lineCount + " line input file produces " + numFiles + " output files, with a max of " + maxLines + " lines");
        System.out.println("");

        System.out.println("***** GENERATING OUTPUT *****");
        System.out.println("");

        for(int i = 1; i <= numFiles; i++){
            System.out.println("Generating " + namePart + "-" + i + txtPart);
        }

        System.out.println("");
        System.out.println("FILE CREATION SUCCESSFUL");

        try {
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNext()) {

                for (int i = 1; i <= numFiles; i++) {

                    // Only create a new file if the previous file is full?
                    String outputFileName = namePart + "-" + i + txtPart;
                    File outputFile = new File(outputFileName);


                    try (PrintWriter pw = new PrintWriter(outputFile)) {
                        for (int j = 0; j < maxLines && !lineList.isEmpty(); j++) {
                            String output = lineList.get(j);
                            pw.println(output);

                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }

                }
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
