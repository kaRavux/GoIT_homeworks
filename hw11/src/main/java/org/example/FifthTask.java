package org.example;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class FifthTask {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 1, 1);
        Stream<Integer> second = Stream.of(2, 2, 2);

        zip(first, second).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIter = Objects.requireNonNull(first).iterator();
        Iterator<T> secondIter = Objects.requireNonNull(second).iterator();

        Stream.Builder<T> builder = Stream.builder();

        while (firstIter.hasNext() || secondIter.hasNext()) {
            if (firstIter.hasNext()) {
                builder.add(firstIter.next());
            }
            if (secondIter.hasNext()) {
                builder.add(secondIter.next());
            }
        }

        return builder.build();
    }
}
