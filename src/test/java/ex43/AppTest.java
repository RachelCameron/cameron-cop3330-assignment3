package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise 43.
 */

public class AppTest {
    @Test
    public void testWebsite()  {
        String title = "Great Title";
        String author = "Best Author";

        String website = App.generateWebsite(title, author, false, false);
        assertTrue(website.contains("<title>" + title + "</title>"));
        assertTrue(website.contains("<meta name=\"author\" content=\"" +
                author + "\">"));

        assertTrue(Files.exists(Path.of("website/" + title)));
    }
}
