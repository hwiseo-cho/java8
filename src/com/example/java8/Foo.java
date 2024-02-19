package com.example.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {


        // java8 이전
        // 익명 내부 클래스
        RunSometing runSometing = new RunSometing() {
            @Override
            public void doIt() {
                System.out.println("hi");
            }
        };
        runSometing.doIt();

        // java8
        // 람다 표현식
        RunSometing runSometing2 = () -> {
            System.out.println("hi");
        };
        runSometing2.doIt();

        /**
         * Function<T,V>
         * T 타입을 받아서 V 타입을 리턴하는 함수 인터페이스
         */

        // java8 이전
        Plust10 plust10 = new Plust10();
        plust10.apply(3);

        // java8
        Function<Integer, Integer> plust11 = (num) -> num + 10;
        plust11.apply(3);

        Function<Integer, Integer> plust12 = (num) -> num * 2;
        plust11.compose(plust12);
        plust11.andThen(plust12);

        /**
         * Consumer<T>
         * T 값을 받아서 아무것도 리턴하지 않는 함수 인터페이스
         */

        Consumer<Integer> printT = (i) -> System.out.println(i);

        /**
         * Supplier<T>
         * T 타입의 값을 제공하는 함수 인터페이스
         */
        Supplier<Integer> get10 = () -> 10;

        /**
         * Predicate<T>
         * T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
         */
        Predicate<String> startsWithHwiseo = (s) -> s.startsWith("hwiseo");

    }
}
