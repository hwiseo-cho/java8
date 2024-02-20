package com.example.java8.interfac;

public interface FooInter {

    void printName();

    // 기본 메소드(Default Methods)
    /**
     * @implSpec 이렇게 적어주는게 좋다
     */
    // Object 메소드는 정의 불가
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    };

    static void printNm() {
        System.out.println("static");
    }

    String getName();
}
