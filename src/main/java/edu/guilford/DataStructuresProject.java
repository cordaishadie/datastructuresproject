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

        // print the linkedlist
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
        // Step 5: Sort the words in the Shadie_C_ResearchPaper.txt file alphabetically

    }

    // method that returns the number of words in the Shadie_C_ResearchPaper.txt
    // file.

    public static LinkedList readData(Scanner scan) {
        // read the words from the Shadie_C_ResearchPaper.txt file.
        LinkedList inputWords = new LinkedList();
        String word = scan.next();
        // seperate the words using the space character.

        try {
            for (int i = 0; i < 5000; i++) {
                if (scan.hasNext()) {
                    word = scan.next();
                    inputWords.add(word);

                }
            }
        } catch (NoSuchElementException ex) {
            System.out.println("There are no more words in the file.");
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

}