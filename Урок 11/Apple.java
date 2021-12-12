package com.geekbrains.Lesson11;

public class Apple extends Fruits{

    public Apple(int number) {
        super(140.4f, number);
    }

    @Override
    public String toString() {
        return String.format("яблоки 🍏");
    }
}
