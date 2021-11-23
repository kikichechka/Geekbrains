package com.geekbrains.Lesson6;

public class Animal {
    protected String name;
    public static int count_cat = 0;
    public static int count_dog = 0;

    Animal(String name) {
        this.name = name;
    }

    public void printAnimal() {
        System.out.println(name);
    }

}
interface Activity {
    void run (int run);
    void swim (int swim);
}