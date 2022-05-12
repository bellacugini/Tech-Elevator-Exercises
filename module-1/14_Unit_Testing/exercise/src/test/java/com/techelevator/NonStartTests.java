package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonStartTests {

    @Test
    public void test_for_non_start() {
        NonStart testMethods = new NonStart();
        String testA = "Hello";
        String testB = "There";
        String expectedResult = "ellohere";
        String actualResult = testMethods.getPartialString(testA, testB);

        assertEquals(expectedResult, actualResult);

        String testA2 = "";
        String testB2 = "";
        String expectedResult2 = "";
        String actualResult2 = testMethods.getPartialString(testA2, testB2);

        assertEquals(expectedResult2, actualResult2);

        String testA3 = "Hello";
        String testB3 = "";
        String expectedResult3 = "ello";
        String actualResult3 = testMethods.getPartialString(testA3, testB3);

        assertEquals(expectedResult3, actualResult3);

        String testA4 = "";
        String testB4 = "There";
        String expectedResult4 = "here";
        String actualResult4 = testMethods.getPartialString(testA4, testB4);

        assertEquals(expectedResult4, actualResult4);


    }
}
