package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

/**
 * Exercise 41.
 */

public class AppTest {
    @Test
    public void testSortList()  {
        // test an empty list
        ArrayList<String> empty =  new ArrayList<>();
        App.sortList(empty);
        testSorted(empty);

        // test a list with only one element
        empty.add("A");
        App.sortList(empty);
        testSorted(empty);

        // test a random list
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(String.valueOf(getRandom(1, 1000)));
        }

        App.sortList(list);
        testSorted(list);
    }

    private static void testSorted(ArrayList<String> list)  {
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }
    }

    public static int getRandom(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }
}
