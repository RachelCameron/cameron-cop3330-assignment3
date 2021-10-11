package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Exercise 43.
 * Prompts user to input the name of the site.
 * Prompts user to input the author of the site.
 * Asks user if they want a JavaScript file folder.
 * Asks user if they want a CSS file folder.
 * Generate files in the working directory that
 * correspond to user input above. Will always have
 * the "index.html" file (contains the inputs for
 * title and author); may have "css" or "js" folders
 * depending on what the user input previously.
 * Methods are properly named for clarity.
 */

public class App {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do  {
            generateWebsite();
        } while (true);
    }

    public static String getInput(String prompt)  {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static String generateWebsite()  {
        String siteName = getInput("Site name: ");
        String author = getInput("Author: ");
        boolean jsFolder = getInput("Do you want a folder for JavaScript? ")
                .equalsIgnoreCase("y");
        boolean cssFolder = getInput("Do you want a folder for CSS? ")
                .equalsIgnoreCase("y");

        String website = generateWebsite(siteName, author, jsFolder, cssFolder);
        return website;
    }

    public static boolean createDirectory(String name)  {
        File dir = new File(name);
        try {
            System.out.println("Created " + dir.getCanonicalPath());
        }
        catch (Exception e)  {

        }
        return dir.mkdir();
    }

    public static void createHtml(String content, String filename)  {
        try {
            File file = new File(filename);
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.flush();
            writer.close();

            System.out.println("Created " + file.getCanonicalPath());
        } catch (Exception e) {
            System.out.println("Could not create html file!");
        }

    }

    public static String generateWebsite(String siteName, String author,
                                         boolean js, boolean css)  {
        String parentFolder = "website";
        String innerFolder = parentFolder + "/" + siteName;

        createDirectory(parentFolder);
        createDirectory(innerFolder);

        String content = String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>%s</title>\n" +
                "    <meta name=\"author\" content=\"%s\">\n" +
                "  </head>\n" +
                "  \n" +
                "  <body>\n" +
                "  </body>\n" +
                "</html>", siteName, author);
        createHtml(content, innerFolder + "/index.html");

        if (js)  {
            createDirectory(innerFolder + "/js");
        }
        if (css)  {
            createDirectory(innerFolder + "/css");
        }

        return content;
    }
}