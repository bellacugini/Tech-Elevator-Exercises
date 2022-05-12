package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

    private Car car;

    private List<Car> carList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);

    public Module1CodingAssessment(Car car) {
        this.car = car;
    }

    public Module1CodingAssessment() {

    }

    public static void main(String[] args) {
        Car car = new Car();
        Module1CodingAssessment modAssessment = new Module1CodingAssessment(car);
        modAssessment.run();
    }


    public void run() {
        try {
            File file = new File("CarInput.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strArr = line.split(",");

                int year = Integer.parseInt(strArr[0]);
                String make = strArr[1];
                String isClassicCar = strArr[2];

                carList.add(new Car(year, make, isClassicCar));

            }
        } catch (FileNotFoundException e) {
            System.out.println();
        }
        int sumOfAllAges = 0;
        for (Car car : carList) {

            car.toString(car.getYear(), car.getMake());
            car.eCheck(car.getAge(car.getYear()), car.getIsClassicCar(), 2016);
            System.out.println("");

            sumOfAllAges += car.getAge(car.getYear());
        }
        System.out.println("The sum of all of the cars ages: " + sumOfAllAges);
    }

}
