package com.geekbrains.Lesson11;

public class Orange extends Fruits {

    public Orange(int number) {
        super(280.6f, number);
    }

    @Override
    public String toString() {
        return String.format("апельсины 🍊");
    }
}
