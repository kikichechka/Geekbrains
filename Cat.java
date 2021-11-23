package com.geekbrains.Lesson6;

class Cat extends Animal implements Activity{

    public Cat(String name) {
        super(name);
        count_cat++;
        printAnimal();
    }

    @Override
    public void printAnimal() {
        System.out.printf("Котик: %s, ", name);
    }

    @Override
    public void run(int run) {
        if  (run < 200)
            System.out.printf("пробежал %s метров, ", run);
        else
            System.out.printf("не смог пробежать %s метров, а всего 200, ", run);
    }

    @Override
    public void swim(int swim) {
        System.out.println("не умеет плавать.");
    }
}


