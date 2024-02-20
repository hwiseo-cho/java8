package com.example.java8.interfac;

public class FooInterImpl implements FooInter{

    String name;

    public FooInterImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
