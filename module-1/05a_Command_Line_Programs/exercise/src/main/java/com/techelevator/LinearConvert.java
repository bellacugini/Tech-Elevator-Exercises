package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String lengthStr = scanner.nextLine();
		double length = Double.parseDouble(lengthStr);

		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		String measurementStr = scanner.nextLine();
		char measurementChar = measurementStr.charAt(0);

		int m = 0;
		int f = 0;

		if(measurementChar == 'm'){
			m = (int) (length);
			f = (int) (m * 3.2808399);
			System.out.print(m + "m is " + f + "f");
		}
		else if(measurementChar == 'f'){
			f = (int) (length);
			m = (int) (f * 0.3048);
			System.out.print(f + "f is " + m + "m");

		}
	}

}
