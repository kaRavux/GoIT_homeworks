package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondTask {
    public static void main(String[] args) {
        List<String> names = List.of("Honza", "Zinaida", "Josef", "Andrey", "David", "Pavel");
        System.out.println(sortNamesFromZtoA(names));
    }

    private static List<String> sortNamesFromZtoA(List<String> names) {
        List<String> newNames;
                newNames = names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return newNames;
    }

}