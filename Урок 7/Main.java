package com.geekbrains.Lesson7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer;
        int counter = 0;
        Plate plate = new Plate(0);

        Cat[] cat = new Cat[8];
        cat[0] = new Cat("Рыжик", 50);
        cat[1] = new Cat("Барсик", 63);
        cat[2] = new Cat("Пухляш", 97);
        cat[3] = new Cat("Беляш", 69);
        cat[4] = new Cat("Муркин", 49);
        cat[5] = new Cat("Хвостик", 73);
        cat[6] = new Cat("Маркиз", 82);
        cat[7] = new Cat("Леон", 42);
        plate.infoFood();

        do {
            do {
                System.out.print("\nДавайте накормим голодных котиков. Насыпьте в миску корм (введите колличесто грамм): >>> ");
                answer = sc.nextInt();
            } while (!isSellValid(answer));
            plate.food += answer;

        for (Cat o : cat) {
            if (o.satiety == true) {//  если котик ранее был накормлен
                System.out.printf("🐈 Котик %s еще не проголодался, ведь он ранее уже съел %s грамм корма!\n", o.name, o.appetite);
                counter++;
            } else {
                o.eat(plate); // если нет, то пытаемся его накормить
                if (o.satiety == true) {
                    System.out.printf("🐈 Котик %s вкусно полакомился, съел %s грамм корма и больше не голоден!\n", o.name, o.appetite);
                    counter++;
                } else
                    System.out.printf("🐈 Котику %sу не хватило корма в миске😿, и он остался голодным.\n", o.name, o.appetite);
            }
        }
        plate.infoFood();

        } while (counter < cat.length);
        System.out.println("Здорово! Вы накормили всех котов👏\n⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕");
    }

    public static boolean isSellValid(int answer) {
        if (answer < 0) {
            System.out.println("❌‼Вы не можете добавить в миску отрицательное колличество корма‼❌");
            return false;
        }
        if (answer == 0) {
            System.out.println("Пожалейте бедных котиков!😥");
            return false;
        }
        return true;
    }
}

