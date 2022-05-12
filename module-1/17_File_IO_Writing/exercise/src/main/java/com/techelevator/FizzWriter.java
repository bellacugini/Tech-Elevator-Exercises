package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter output file: ");
		String output = scanner.nextLine();
		File outputFile = new File(output);

		try(PrintWriter pw = new PrintWriter(outputFile)){
			for(int i = 1; i <= 300; i++){
				if ((i % 3) == 0 && (i % 5) == 0) {
					pw.println("FizzBuzz");
				} else if ((i % 3) == 0) {
					pw.println("Fizz");
				} else if ((i % 5) == 0) {
					pw.println("Buzz");
				} else {
					pw.println(i);
				}
			}

		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}
}
