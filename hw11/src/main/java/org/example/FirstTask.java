package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstTask {
    public static void main(String[] args) {
        List<String> names = List.of("Honza", "Zinaida", "Josef", "Andrey", "David", "Pavel");
        System.out.println(onlyOddNmaes(names));
    }

    private static String onlyOddNmaes(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

}
