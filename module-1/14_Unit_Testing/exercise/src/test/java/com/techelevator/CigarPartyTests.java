package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CigarPartyTests {

    @Test
    public void test_for_minimum() {
        CigarParty testMethods = new CigarParty();
        int testCigars = 30;
        boolean testWeekend = false;
        boolean expectedResult = false;
        boolean actualResult = testMethods.haveParty(testCigars, testWeekend);

        assertEquals(expectedResult, actualResult);

        int testCigars2 = 30;
        boolean testWeekend2 = true;
        boolean expectedResult2 = false;
        boolean actualResult2 = testMethods.haveParty(testCigars2, testWeekend2);

        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void test_for_max() {
        CigarParty testMethods = new CigarParty();
        int testCigars = 60;
        boolean testWeekend = false;
        boolean expectedResult = true;
        boolean actualResult = testMethods.haveParty(testCigars, testWeekend);

        assertEquals(expectedResult, actualResult);

        int testCigars2 = 65;
        boolean testWeekend2 = false;
        boolean expectedResult2 = false;
        boolean actualResult2 = testMethods.haveParty(testCigars2, testWeekend2);

        assertEquals(expectedResult2, actualResult2);

        int testCigars3 = 70;
        boolean testWeekend3 = true;
        boolean expectedResult3 = true;
        boolean actualResult3 = testMethods.haveParty(testCigars3, testWeekend3);

        assertEquals(expectedResult3, actualResult3);
    }


}
