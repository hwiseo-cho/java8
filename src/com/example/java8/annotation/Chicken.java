package com.example.java8.annotation;

import java.lang.annotation.*;

//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
