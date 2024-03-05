package com.example.java8.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ChickenContainer {

    Chicken[] value();
}
