package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise 42.
 *
 * Reads data from file and displays it as a table.
 */

public class App {
    public static void main(String[] args) {
        try {
            ArrayList<Person> people = getRecords("src/main/java/ex42/exercise42_input.txt");
            printTable(people);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file!");
        }
    }

    public static Person personFromRecord(String record)  {
        String[] data = record.split(",");
        return new Person(data[1], data[0], Double.parseDouble(data[2]));
    }

    public static ArrayList<Person> getRecords(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));

        ArrayList<Person> people = new ArrayList<>();

        while (input.hasNextLine())  {
            Person person = personFromRecord(input.nextLine());
            people.add(person);
        }

        input.close();

        return people;
    }

    public static void printTable(ArrayList<Person> people)  {
        String f = "%-12s%-12s%-12s%n";
        String f2 = "%-12s%-12s%-12.0f%n";
        System.out.printf(f, "Last", "First", "Salary");
        System.out.println("------------------------------");
        for (Person person: people) {
            System.out.format(f2, person.getLast(),
                    person.getFirst(), person.getSalary());
        }
    }
}