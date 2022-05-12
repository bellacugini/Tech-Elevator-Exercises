package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxEnd3Tests {

    @Test
    public void test_for_maxEnd() {
        MaxEnd3 testMethods = new MaxEnd3();

        int[] testNums = {1, 2, 3};

        int[] actualResult = testMethods.makeArray(testNums);
        int[] expectedResult = {3, 3, 3};

        assertEquals(expectedResult, actualResult);


        int[] testNums2 = {11, 5, 9};
        int[] actualResult2 = testMethods.makeArray(testNums2);
        int[] expectedResult2 = {11, 11, 11};

        assertEquals(expectedResult2, actualResult2);

    }
}
