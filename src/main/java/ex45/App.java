package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise 45.
 * Reads text from a text file and replace
 * all cases of the word "utilize" with the
 * word "use". Prints an error if the input
 * file is not properly located. Methods are
 * properly named for clarity.
 */

public class App {
    public static void main(String[] args) {
        try {
            ArrayList<String> sentence = readListFromFile("src/main/java/ex45/exercise45_input.txt");

            System.out.println("Original text:");
            print(sentence);

            String keyword = "utilize";
            String replace = "use";

            sentence = replaceWord(sentence, keyword, replace);
            System.out.println("\nAltered text:");
            print(sentence);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file!");
        }
    }

    public static void print(ArrayList<String> list)  {
        for (String s: list)  {
            System.out.println(s);
        }
    }

    public static ArrayList<String> replaceWord(ArrayList<String> list, String word, String replacement)  {

        for (int i = 0; i < list.size() - 1; i++) {
            String current = list.get(i);
            if (current.equals(word))  {
                list.set(i, replacement);
            }
        }

        return(list);

    }

    public static ArrayList<String> readListFromFile(String filename) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        Scanner input = new Scanner(new File(filename)).useDelimiter("\s+");
        while (input.hasNext())
        {
            result.add(input.next());
        }
        input.close();
        return result;
    }
}