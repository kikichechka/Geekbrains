package com.geekbrains.Lesson6;

public class Dog extends Animal implements Activity{
    public Dog(String name) {
        super(name);
        count_dog++;
        printAnimal();

    }

    @Override
    public void printAnimal() {
        System.out.printf("Собака: %s, ", name);
    }

    @Override
    public void run(int run) {
        if  (run < 500)
            System.out.printf("пробежала %s метров; ", run);
        else
            System.out.printf("устала и не смогла пробежать %s метров, а всего 200; ", run);
    }

    @Override
    public void swim(int swim) {
        if (swim < 10)
            System.out.printf("проплыла %s метров.\n", swim);
        else
            System.out.printf("устала и не смогла проплыть %s метров, а всего 10.\n", swim);
    }
}
