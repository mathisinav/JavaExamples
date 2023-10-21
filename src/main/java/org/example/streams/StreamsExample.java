package org.example.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {
    public static void main(String[] args) {
        System.out.println("In StreamsExample !!!");
        filterWithCount();
    }

    public static void basicStreams() {

    }

    public static void filterWithCount() {
        List<String> words = Arrays.asList("One", " ", "two", " ", "three", "four", " ", "");
        long count = words.stream().filter(word -> word.trim().isEmpty()).count();
        System.out.println("Count of empty strings: "+ count);
    }
}
