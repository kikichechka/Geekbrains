package com.geekbrains.Lesson6;

public class Main {
    public static void main(String[] args) {
        Activity cat1 = new Cat("Маркиз");
        cat1.run(320);
        cat1.swim(13);

        Activity cat2 = new Cat("Пушистик");
        cat2.run(130);
        cat2.swim(4);

        Activity dog1 = new Dog("Шарик");
        dog1.run(317);
        dog1.swim(18);

        Activity dog2 = new Dog("Лариска");
        dog2.run(507);
        dog2.swim(5);

        Activity dog3 = new Dog("Бобик");
        dog3.run(65);
        dog3.swim(9);

    System.out.printf("\nВсего создано %s животных. Из них котов: %s, собак: %s.", (Cat.count_cat + Dog.count_dog), Cat.count_cat, Dog.count_dog);

    }
}

