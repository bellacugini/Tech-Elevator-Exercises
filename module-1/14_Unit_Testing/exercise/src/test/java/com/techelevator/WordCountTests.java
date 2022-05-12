package com.techelevator;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordCountTests {

    @Test
    public void test_word_count() {

        WordCount testMethods = new WordCount();

        String [] testArr = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> actualResult = testMethods.getCount(testArr);

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("ba", 2);
        expectedResult.put("black", 1);
        expectedResult.put("sheep", 1);

        assertEquals(expectedResult, actualResult);
    }
}
