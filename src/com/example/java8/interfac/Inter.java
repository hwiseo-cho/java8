package com.example.java8.interfac;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Inter {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        // 기존
        for (String s : list) {
            System.out.println(s);
        }

        Spliterator<String> spliterator = list.spliterator();
        while (spliterator.tryAdvance(System.out::println));

        // java8
        list.forEach(System.out::println);

        long count = list.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("1"))
                .count();

        list.removeIf(s -> s.startsWith("1"));

        // 문자열 정렬
        list.sort(String::compareToIgnoreCase);
        list.sort(String::compareToIgnoreCase);
    }
}
