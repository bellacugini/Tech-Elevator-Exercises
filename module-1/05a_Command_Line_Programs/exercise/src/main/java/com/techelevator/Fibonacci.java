package com.techelevator;

import java.util.Arrays;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		String numberStr = scanner.nextLine();
		int number = Integer.parseInt(numberStr);
		int fibonacciArray[] = new int[number];
		fibonacciArray[0] = 0;
		fibonacciArray[1] = 1;
		System.out.print(fibonacciArray[0] + ", " + fibonacciArray[1]);

		for (int i = 2; i < number; i++) {
			fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
			if(fibonacciArray[i] > number){
				break;
			}
			System.out.print(", " + fibonacciArray[i]);
		}

		}

	}

