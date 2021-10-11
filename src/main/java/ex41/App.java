package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise 41.
 *
 * Reads the list of names from a text file and
 * sorts the list alphabetically.
 */

public class App {
    public static void main(String[] args) {
        try {
            ArrayList<String> names = readListFromFile("src/main/java/ex41/exercise41_input.txt");
            System.out.println(">> Unsorted list of names <<\n");
            print(names);

            System.out.println("\n>> Sorted list of names <<");
            System.out.println("\nTotal of " + names.size() + " names");
            System.out.println("-----------------");
            sortList(names);
            print(names);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file!");
        }
    }

    public static void print(ArrayList<String> list)  {
        for (String s: list)  {
            System.out.println(s);
        }
    }

    public static void sortList(ArrayList<String> list)  {
        boolean isSorted;
        do  {
            isSorted = true;

            for (int i = 0; i < list.size() - 1; i++) {
                String current = list.get(i);
                String next = list.get(i + 1);

                if (next.compareTo(current) < 0)  {
                    list.set(i, next);
                    list.set(i + 1, current);

                    isSorted = false;
                }
            }
        } while (!isSorted);
    }

    public static ArrayList<String> readListFromFile(String filename) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();

        Scanner input = new Scanner(new File(filename));
        while (input.hasNextLine())  {
            result.add(input.nextLine());
        }
        input.close();

        return result;
    }
}