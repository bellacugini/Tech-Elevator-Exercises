package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SameFirstLastTests {

    @Test
    public void test_for_same_first_last() {
        SameFirstLast testMethods = new SameFirstLast();

        int[] testArr = {1,2,3};
        boolean expectedResult = false;
        boolean actualResult = testMethods.isItTheSame(testArr);

        assertEquals(expectedResult, actualResult);


        int[] testArr2 = {1,2,3,1};
        boolean expectedResult2 = true;
        boolean actualResult2 = testMethods.isItTheSame(testArr2);

        assertEquals(expectedResult2, actualResult2);

        int[] testArr3 = {1,2,1};
        boolean expectedResult3 = true;
        boolean actualResult3 = testMethods.isItTheSame(testArr3);

        assertEquals(expectedResult3, actualResult3);

    }
}
