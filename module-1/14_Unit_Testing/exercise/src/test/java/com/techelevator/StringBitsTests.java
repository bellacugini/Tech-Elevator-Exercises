package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBitsTests {
    @Test
    public void test_for_string_bits() {

        StringBits testMethods = new StringBits();

        String testStr = "Hello";
        String expectedResult = "Hlo";
        String actualResult = testMethods.getBits(testStr);

        assertEquals(expectedResult, actualResult);

        String testStr2 = "Hi";
        String expectedResult2 = "H";
        String actualResult2 = testMethods.getBits(testStr2);

        assertEquals(expectedResult2, actualResult2);

        String testStr3 = "Heeololeo";
        String expectedResult3 = "Hello";
        String actualResult3 = testMethods.getBits(testStr3);

        assertEquals(expectedResult3, actualResult3);
    }
}
