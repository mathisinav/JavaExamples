package org.example.streams;

import org.example.util.Customer;
import org.example.util.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        System.out.println("In StreamsExample !!!");
        filterWithCount();
        removeEmptyStrings();
        wordsToUppercase();
        sortWithFindfirst();
        sortWithFilter();
        filterWithMap();
        map();
        flatMap();
    }

    public static void basicStreams() {

    }

    public static void filterWithCount() {
        List<String> words = Arrays.asList("One", " ", "two", " ", "three", "four", " ", "");
        long count = words.stream().filter(word -> word.trim().isEmpty()).count();
        System.out.println("Count of empty strings: "+ count);
    }

    public static void removeEmptyStrings() {
        List<String> words = Arrays.asList("One", " ", "two", " ", "three", "four", " ", "");
        List<String> nonEmptyWords = words.stream().filter(word -> !word.trim().isEmpty()).collect(Collectors.toList());
        System.out.println("non empty workds :"+nonEmptyWords);
    }

    public static void wordsToUppercase() {
        List<String> words = Arrays.asList("One", "two", "three", "four");
        List<String> uppercaseWords = words.stream().map(w -> w.toUpperCase()).collect(Collectors.toList());
        System.out.println("uppercase words :"+uppercaseWords);
    }

    public static void sortWithFindfirst() {
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void sortWithFilter() {
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)
                .filter(n -> n.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    public static void filterWithMap() {
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    public static void map() {
        List<Customer> customers = Domain.getAll();
        customers.stream()
                .map(c -> c.getEmail())
                .forEach(System.out::println);
    }

    public static void flatMap() {
        List<Customer> customers = Domain.getAll();
        List<String> phoneNumbers = customers.stream()
                .flatMap(c -> c.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);
    }
}
