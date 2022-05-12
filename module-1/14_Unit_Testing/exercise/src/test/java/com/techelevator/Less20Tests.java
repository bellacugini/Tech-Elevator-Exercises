package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Less20Tests {

    @Test
    public void test_for_less20() {
        Less20 testMethods = new Less20();
        int testN = 18;
        boolean expectedResult = true;
        boolean actualResult = testMethods.isLessThanMultipleOf20(testN);

        assertEquals(expectedResult, actualResult);

        int testN2 = 20;
        boolean expectedResult2 = false;
        boolean actualResult2 = testMethods.isLessThanMultipleOf20(testN2);

        assertEquals(expectedResult2, actualResult2);

    }

}
