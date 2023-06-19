package org.example;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FourthTask {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = BigInteger.valueOf(2).pow(48).longValue();
        long seed = 0;
        int numberOfElements = 50;

        randomStream(a, c, m, seed)
                .limit(numberOfElements)
                .forEach(System.out::println);
    }

    private static Stream<Long> randomStream(long a, long c, long m, long seed) {
        UnaryOperator<Long> function;

        function = x -> BigInteger.valueOf(a)
                .multiply(BigInteger.valueOf(x))
                .add(BigInteger.valueOf(c))
                .mod(BigInteger.valueOf(m))
                .longValue();

        return Stream.iterate(seed, function);
    }
}
