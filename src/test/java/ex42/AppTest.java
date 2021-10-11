package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise 42.
 */

public class AppTest {
    @Test
    public void testParsing()  {
        String s = "Ling,Mai,55900";
        Person person = App.personFromRecord(s);
        assertEquals("Ling", person.getLast());
        assertEquals("Mai", person.getFirst());
        assertEquals(55900, person.getSalary());
    }
}