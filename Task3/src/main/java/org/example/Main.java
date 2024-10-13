package org.example;

import java.io.*;
import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(GraphsFinder.class.getName());

    public static void main(String[] args) throws IOException {

        String[] input = getStringTableFromFile("src/main/resources/numbersList.txt");
        GraphsFinder graphsFinder = new GraphsFinder();
        try {
            graphsFinder.showNumberOfGraphs(input);
        } catch (NullPointerException e) {
            log.warning("This file is empty. Please provide data to a file numbersList.txt");
        }
    }

    private static String[] getStringTableFromFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            builder.append(currentLine).append(",");
        }
        reader.close();
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString().split(",");
    }
}