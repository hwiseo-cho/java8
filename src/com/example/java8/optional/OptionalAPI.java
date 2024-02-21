package com.example.java8.optional;

import java.util.*;

public class OptionalAPI {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Map<String, String> map = new HashMap<>();
        map.put("1", "test");

        // Optional은 메소드 리턴 으로만 주는게 좋다

        Optional<String> s = Optional.ofNullable(map.get("2"));
        System.out.println(s);

        Optional<String> first = list.stream()
                .filter(l -> l.equals("1"))
                .findFirst();

        System.out.println(first);
        first.ifPresent(k -> System.out.println(k));
    }
}
