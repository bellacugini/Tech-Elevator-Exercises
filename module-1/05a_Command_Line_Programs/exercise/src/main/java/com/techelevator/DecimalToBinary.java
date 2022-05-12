package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String inputStr = scanner.nextLine();
		String[] binaryArray = inputStr.split(" ");
		int binary[] = new int[32];

		for (int i = 0; i < binaryArray.length; i++) {
			int index = 0;
			int number = Integer.parseInt(binaryArray[i]);

			while (number > 0) {
				int remainder = number % 2;
				binary[index++] = remainder;
				number = number / 2;
			}
			System.out.print(binaryArray[i] + " in binary is ");
			for (int j = index - 1; j >= 0; j--) {
				System.out.print(binary[j]);
			}

			System.out.println("");
		}
	}
}