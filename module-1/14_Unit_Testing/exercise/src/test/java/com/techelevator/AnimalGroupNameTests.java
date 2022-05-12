package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalGroupNameTests {
    @Test
    public void test_for_Pigeon() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "pigeon";
        String expectedResult = "Kit";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_Flamingo() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "flamingo";
        String expectedResult = "Pat";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_Deer() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "deer";
        String expectedResult = "Herd";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_Dog() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "dog";
        String expectedResult = "Pack";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_Crocodile() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "crocodile";
        String expectedResult = "Float";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_null() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = null;
        String expectedResult = "unknown";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_for_unknown_animal() {

        AnimalGroupName testMethods = new AnimalGroupName();
        String testAnimalName = "badger";
        String expectedResult = "unknown";
        String actualResult = testMethods.getHerd(testAnimalName);

        assertEquals(expectedResult, actualResult);
    }
}
