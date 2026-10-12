package com.eidiko.service_registry.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Programs {
    public static void main(String[] args) {
        List<Integer> numbers =
                Arrays.asList(10, 20, 10, 30, 20, 40, 30, 50);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
