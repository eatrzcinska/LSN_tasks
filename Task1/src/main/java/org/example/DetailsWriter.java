package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DetailsWriter {

    private static Logger log = Logger.getLogger(DetailsWriter.class.getName());

    public void presentOutput(String input) {
        String[] table = input.split(" ");
        List<Integer> list;
        try {
            list = distinctAndSort(table);
        } catch (NumberFormatException e) {
            log.warning("Wrong format of data. Please provide numbers separated by spaces.");
            return;
        }
        list.stream().map(s1 -> s1.toString() + " ").forEach(System.out::print);
        System.out.println();
        System.out.println("count: " + count(table));
        System.out.println("distinct: " + getDistinct(list));
        System.out.println("min: " + getMin(list));
        System.out.println("max: " + getMax(list));
    }

    private List<Integer> distinctAndSort(String[] table) {
        return Arrays.stream(table)
                .distinct()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private int count(String[] table) {
        return table.length;
    }

    private int getDistinct(List<Integer> list) {
        return list.size();
    }

    private int getMin(List<Integer> list) {
        return list.get(0);
    }

    private int getMax(List<Integer> list) {
        return list.get(list.size() - 1);
    }

}
