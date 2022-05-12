package com.techelevator;

import java.io.*;

import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

		try (Scanner userInput = new Scanner(System.in)) {

			File inputFile;

			while (true) {
				System.out.println("Enter file name: ");
				String path = userInput.nextLine();

				inputFile = new File(path);

				if (inputFile.exists() == false) {
					System.out.println("File does not exist");
					continue;
				} else if (inputFile.isFile() == false) {
					System.out.println("Not a file");
					continue;
				}
				break;
			}

			System.out.println("Enter search word: ");
			String searchWord = userInput.nextLine();

			if (searchWord == null || searchWord.isEmpty()) {
				System.out.println("Search word is empty");
				System.exit(1);
			}

			System.out.println("Should search be case sensitive? (Y\\N): ");
			boolean caseSensitive = userInput.nextLine().toLowerCase().equals("y");

			int lineNumber = 1;
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
				while (inputScanner.hasNextLine()) {
					String line = inputScanner.nextLine();
					if (caseSensitive == false) {
						if (line.toLowerCase().contains(searchWord.toLowerCase())) {
							System.out.println(lineNumber + ") " + line);
						}

					} else {
						if (line.contains(searchWord)) {
							System.out.println(lineNumber + ") " + line);
						}
					}
					lineNumber++;
				}
			}
		}
	}
}

