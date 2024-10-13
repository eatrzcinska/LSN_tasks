package org.example;

import java.io.*;
import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(PairsFinder.class.getName());

    public static void main(String[] args) throws IOException {

        String input = getStringFromFile("src/main/resources/numbersList.txt");
        PairsFinder pairsFinder = new PairsFinder();
        try {
            pairsFinder.showPairs(input);
        } catch (NullPointerException e) {
            log.warning("This file is empty. Please provide data to a file numbersList.txt");
        }
    }

    private static String getStringFromFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String numbers = reader.readLine();
        reader.close();
        return numbers;
    }
}