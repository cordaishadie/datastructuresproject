package edu.guilford;

import java.util.Collections;

public class WordSet implements Comparable<WordSet> {
    // attributes
    private String word;
    private int frequency;

    // constructor
    public WordSet(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    // getters and setters
    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    // toString method
    @Override
    public String toString() {
        return word + " " + frequency + "\n";
    }

    @Override
    public int compareTo(WordSet wordFrequency) {
        if (this.frequency > wordFrequency.frequency) {
            return 1;
        } else if (this.frequency < wordFrequency.frequency) {
            return -1;
        } else {
            return 0;
        }
    } 

}
