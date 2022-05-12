package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String tempStr = scanner.nextLine();
		double temp = Double.parseDouble(tempStr);
		int temperatureFarenheit = 0;
		int temperatureCelcius = 0;

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String celsiusOrFarenheit = scanner.nextLine();
		char celsiusOrFarenheitChar = celsiusOrFarenheit.charAt(0);


		if(celsiusOrFarenheitChar == 'C'){
			temperatureCelcius = (int) temp;
			temperatureFarenheit = (int) (temperatureCelcius * 1.8 + 32);
			System.out.print(temperatureCelcius + "C is " + temperatureFarenheit + "F");
		}
		else if(celsiusOrFarenheitChar == 'F'){
			temperatureFarenheit = (int) temp;
			temperatureCelcius = (int) ((temperatureFarenheit - 32) / 1.8);
			System.out.print(temperatureFarenheit + "F is " + temperatureCelcius + "C");

		}
	}

}
