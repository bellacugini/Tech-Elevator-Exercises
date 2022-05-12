package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateFashionTests {

    @Test
    public void getTableTests(){

        DateFashion testMethods = new DateFashion();

        int testA = 8;
        int testB = 2;
        int expectedResult = 0;
        int actualResult = testMethods.getATable(testA, testB);

        assertEquals(expectedResult, actualResult);

        int testA2 = 9;
        int testB2 = 5;
        int expectedResult2 = 2;
        int actualResult2 = testMethods.getATable(testA2, testB2);

        assertEquals(expectedResult2, actualResult2);

        int testA3 = 4;
        int testB3 = 7;
        int expectedResult3 = 1;
        int actualResult3 = testMethods.getATable(testA3, testB3);

        assertEquals(expectedResult3, actualResult3);

    }

}
