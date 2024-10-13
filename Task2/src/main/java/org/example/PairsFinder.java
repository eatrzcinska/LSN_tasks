package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PairsFinder {

    private static Logger log = Logger.getLogger(PairsFinder.class.getName());
    private static final int SUM = 13;

    public void showPairs(String input) {
        String[] table = input.split(" ");
        List<Integer> list;
        try {
            list = getSortedList(table);
        } catch (NumberFormatException e) {
            log.warning("Wrong format of data. Please provide numbers separated by spaces.");
            return;
        }
        ArrayList<Pair> pairList = findPairs(list);
        pairList.forEach(System.out::println);
    }

    private List<Integer> getSortedList(String[] table) {
        return Arrays.stream(table)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private ArrayList<Pair> findPairs(List<Integer> list) {
        ArrayList<Pair> pairList = new ArrayList<>();
        int firstNumLimit = SUM / 2 + 1;
        for (int i = 0; list.get(i) < firstNumLimit; i++) {
            int number1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int number2 = list.get(j);
                if (number1 + number2 == SUM) {
                    pairList.add(new Pair(number1, number2));
                }
            }
        }
        return pairList;
    }
}
