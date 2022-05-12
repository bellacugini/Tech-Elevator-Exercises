package com.techelevator;

import java.util.Calendar;

public class Car {

    private int year;
    private String make;
    private String isClassicCar;
    private int age;


    public Car(int year, String make, String isClassicCar) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
        int age = 0;
    }

    public Car(int year, String make, String isClassicCar, int age) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
        this.age = age;
    }

    public Car() {

    }

    public int getYear() {

        return year;
    }

    public String getMake() {

        return make;
    }

    public String getIsClassicCar() {

        return isClassicCar;
    }

    public int getAge(int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        age = currentYear - year;
        return age;
    }

    public void eCheck(int age, String isClassicCar, int yearToCheck) {

        if (this.age >= 4 && this.age <= 25) {
            if (this.isClassicCar.equals("false")) {
                if ((yearToCheck % 2 == 0) && (age % 2 == 0)) {
                    System.out.println("This car requires an e-check");
                } else if ((yearToCheck % 2 != 0) && (age % 2 != 0)) {
                    System.out.println("This car requires an e-check");
                }
                else{
                    System.out.println("This car does not require an e-check");
                }
            }
            else if (this.isClassicCar.equals("true")) {
                    System.out.println("This car does not require an e-check");
            }
            else{
                System.out.println("This car does not require an e-check");
            }
        } else {
            System.out.println("This car does not require an e-check");
        }

    }

    public String toString(int year, String make) {

        String str = "CAR - {" + this.year + "} - {" + this.make + "}";
        System.out.println(str);

        return str;
    }

}
