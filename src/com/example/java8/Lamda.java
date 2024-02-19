package com.example.java8;

import java.util.Arrays;
import java.util.function.*;

public class Lamda {

    public static void main(String[] args) {
        /**
         * (인자) -> body;
         */
        // Lamda lamda = new Lamda();
        // lamda.run();

        // static method
        UnaryOperator<String> hi = Greeting::hi;
        // instance method
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        // new method(기본)
        Supplier<Greeting> newGreeting = Greeting::new;
        // new method(값 O)
        Function<String, Greeting> hwiseoGreeting = Greeting::new;
        hwiseoGreeting.apply("hwiseo").getName();
        String[] names = {"asdf","1","2"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }

    private void run() {
        int baseNum = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNum = 11;
                System.out.println(baseNum); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNum) {
                System.out.println(baseNum); // 매게변수로 온 값으로 됨
            }
        };

        // 람다
        // 섀도잉이 일어나지 않음
        // 같은 스코프 안에 동일한 이름 지정 불가
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNum);
        };

        // 이팩티브 파이널이 아니여서 불가
        // baseNum++;


        /**
         * 메소드 레퍼런스
         */

    }

    static class Greeting {
        private String name;

        public Greeting() {}

        public Greeting(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String hello(String name) {
            return "hello " + name;
        }

        public static String hi(String name) {
            return "hi " + name;
        }
    }
}
