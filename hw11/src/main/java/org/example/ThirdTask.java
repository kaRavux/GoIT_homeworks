package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThirdTask {
    public static void main(String[] args) {
        String[] nums = {"1, 2, 0", "4, 5"};
        System.out.println(sortNames(nums));
    }

    private static List<String> sortNames(String[] nums) {

        List<String> newNums;
        newNums = Arrays.stream(nums)
                .flatMap(s -> Stream.of(s.split(",\\s*")))
                .sorted()
                .collect(Collectors.toList());
        return newNums;
    }

}