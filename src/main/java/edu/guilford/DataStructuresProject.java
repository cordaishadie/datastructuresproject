package edu.guilford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class DataStructuresProject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanFile = null;
        Path dataLocation = null;
        boolean fileExists = false;
        LinkedList sortedList = null;
        TreeSet set = null;
        // String fileName = null;

        // In this part of the program, I wil create a code that sorts the words in the
        // Shadie_C_ResearchPaper.txt file alphabetically and writes them to a new file.

        // Step 1: Get the file that contains the words.
        try {
            // this line of code gets the location of file that contains the words:
            dataLocation = Paths
                    .get(DataStructuresProject.class.getResource("/" + "Shadie_C_ResearchPaper.txt").toURI());
            // Step 2: Read the words from the Shadie_C_ResearchPaper.txt file.
            FileReader dataFile = new FileReader(dataLocation.toFile());
            BufferedReader dataBuffer = new BufferedReader(dataFile); // for efficiency
            scanFile = new Scanner(dataBuffer); // so that we can read the file line by line
            // implement the method that counts the number of words in the
            // Shadie_C_ResearchPaper.txt file.
            sortedList = readData(scanFile);
            // Collections.sort(sortedList);
        } catch (URISyntaxException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // sort the words in the Shadie_C_ResearchPaper.txt file alphabetically
        Collections.sort(sortedList);

        // Step 4: Read the words from the Shadie_C_ResearchPaper.txt file.
        try {
            writeData(sortedList, "output.txt");
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        // In this part of the program, I will a set that contains the words in the
        // LinkedList and the number of times each word appears in the LinkedList.
        set = new TreeSet();
        // add the words in the LinkedList to the set.
        for (int i = 0; i < sortedList.size(); i++) {
            set.add(sortedList.get(i) + " " + Collections.frequency(sortedList, sortedList.get(i)));
        }

        // sort the set by the number of times each word appears
        
    }

    // method that returns the number of words in the Shadie_C_ResearchPaper.txt
    // file.

    public static LinkedList readData(Scanner scan) throws NoSuchElementException, IndexOutOfBoundsException {
        // read the words from the Shadie_C_ResearchPaper.txt file.
        LinkedList inputWords = new LinkedList();
        String word = scan.next();
        // seperate the words using the space character.
        try {
                while (scan.hasNext()) {
                    word = scan.next();
                    // check if the word is a number using the isNumber method.
                    if (isNumber(word) == true) {
                        // go to the next word.
                        continue;
                    }
                    // check the last character of the word to see if it is a letter.
                    while (isPunctuation(word.charAt(word.length() - 1)) == true) {
                        // delete the first character of the word.
                        word = word.substring(0, word.length() - 1);
                    }
                    // check the first character of the word to see if it is a letter.
                    while (isPunctuation(word.charAt(0)) == true) {
                        // delete the last character of the word.
                        word = word.substring(1, word.length());

                    }
                
                // if the word is a word and not a number, add it to the list.
                // but if the word is a number, do not add it to the list.
                if (isNumber(word) == true) {
                    continue;
                } else {
                    word = word.toLowerCase();
                    inputWords.add(word);
                }
            }
        } catch (NoSuchElementException | NumberFormatException | IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return inputWords;
    }

    // method that writes Data to a file.
    public static void writeData(LinkedList sortedList, String location) throws IOException, URISyntaxException {
        Path locationPath = Paths.get(DataStructuresProject.class.getResource("/edu/guilford/").toURI());
        // opens the file for writing
        FileWriter fileLocation = new FileWriter(locationPath.toString() + "/" + location);
        BufferedWriter bufferWrite = new BufferedWriter(fileLocation);
        // writes the data to the file
        for (int i = 0; i < sortedList.size(); i++) {
            bufferWrite.write(sortedList.get(i).toString());
        }
        bufferWrite.close();
    }

    // check if a string is a number using the Integer.parseInt method.
    public static boolean isNumber(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // check if character is a puntuation mark.
    public static boolean isPunctuation(char character) {
        if (character == '.' || character == ',' || character == '?' || character == '!' || character == ':'
                || character == ';' || character == '(' || character == ')' || character == '[' || character == ']'
                || character == '{' || character == '}' || character == '"' || character == '\'' || character == '-'
                || character == '_' || character == '/' || character == '\\' || character == '<' || character == '>'
                || character == '`' || character == '~' || character == '@' || character == '#' || character == '$'
                || character == '%' || character == '^' || character == '&' || character == '*' || character == '+'
                || character == '‘' || character == '’' || character == '“' || character == '”' || character == '’') {
            return true;
        } else {
            return false;
        }
    }

}