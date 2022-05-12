package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class Lucky13Tests {

    @Test
    public void test_for_Lucky13(){
        Lucky13 testMethods = new Lucky13();

        int[] testArr1 = {0, 2, 4};
        boolean expectedResult1 = true;
        boolean actualResult1 = testMethods.getLucky(testArr1);

        assertEquals(expectedResult1, actualResult1);

        int[] testArr2 = {1, 2, 3};
        boolean expectedResult2 = false;
        boolean actualResult2 = testMethods.getLucky(testArr2);

        assertEquals(expectedResult2, actualResult2);
    }

}