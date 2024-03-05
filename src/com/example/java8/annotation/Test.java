package com.example.java8.annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("마늘")
@Chicken("간장")
public class Test {

    public static void main(String[] args) throws @Chicken("양념") RuntimeException {
        List<@Chicken("후라이드")  String> names = Arrays.asList("hwiseo");
    }

    static class FellsLikeChicken<@Chicken("마늘간장") T> {

        public static <@Chicken("배고픔") C> void print (C c) {

        }
    }
}
