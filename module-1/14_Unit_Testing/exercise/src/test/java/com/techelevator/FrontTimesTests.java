package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrontTimesTests {

    @Test
    public void test_for_string_copies() {
        FrontTimes testMethods = new FrontTimes();
        String testStr = "Hi";
        int testN = 3;
        String expectedResult = "HiHiHi";
        String actualResult = testMethods.generateString(testStr, testN);

        assertEquals(expectedResult, actualResult);

        String testStr2 = "Hello";
        int testN2 = 2;
        String expectedResult2 = "HelHel";
        String actualResult2 = testMethods.generateString(testStr2, testN2);

        assertEquals(expectedResult2, actualResult2);
    }
}
