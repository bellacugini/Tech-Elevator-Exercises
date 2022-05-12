package com.techelevator;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    Car car = new Car(1965, "Ford Mustang", "true");

    @Test
    public void test_get_year() {
        int expected = 1965;
        int actual = car.getYear();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_make() {
        String expected = "Ford Mustang";
        String actual = car.getMake();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_isClassicCar() {
        String expected = "true";
        String actual = car.getIsClassicCar();
        assertEquals(expected, actual);
    }
}

