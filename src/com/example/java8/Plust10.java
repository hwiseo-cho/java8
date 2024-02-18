package com.example.java8;

import java.util.function.Function;

public class Plust10 implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
