package com.geekbrains.Lesson8;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.printf("🏆  Добро пожаловать на марафон!  🏆\n⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀⁀\n" +
                "Мы подготовили полосу из 6 препятствий. \n" +
                "Препятствия 2-x видов: беговая дорожка 🏃 ⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚  и  стена |‾‾‾‾‾‾|\n" +
                "⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗\n\n\n");


        Object[] marathons = new Object[6]; // масссив для 6 препятствий
        System.out.print("НАША ПОЛОСА ПРЕПЯТСТВИЙ:\n" +
                "⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗⁗\n📣 START: ");
        for (int i = 0; i < marathons.length; i++) {
            marathons[i] = generateMarathon();
            System.out.print(marathons[i] + " ");
        }
        System.out.println("| FINISH");


        Participants[] participant = new Participants[6]; //массив игроков
        System.out.println("НАШИ УЧАСТНИКИ: ");
        for (int i = 0; i < participant.length; i++) {
            participant[i] = generateParticipants();
            System.out.println(i + 1 + "-й участник: " + participant[i]);
        }
        System.out.print("\nНачнем марафон!!! (нажмите 1 для старта, 0 для выхода) >>>> ");
        int answer = scanner.nextInt();
        int count = 0;

        while (answer == 1) {
            System.out.println("📣 START:");
            do {
                count++;
                for (Object o : marathons) { // идем по препятствиям
                    System.out.println();
                    System.out.println(o);
                    for (Participants a : participant) { // идем по игрокам

                        if (o instanceof Wall) {// если препятствие стена
                            Wall wall = new Wall(((Wall) o).heightWall);
                            a.wallPassing(wall);
                            if (!a.passingWall)  // если не преодолел стену
                                a.jump = a.run = 0; // убираем с препятствия
                            else
                                System.out.printf("%s успешно прошел препятствие!\n", a.name);
                        }
                        if (o instanceof Treadmill) {// если препятствие дорожка
                            Treadmill treadmill = new Treadmill(((Treadmill) o).longTreadmill);
                            a.treadmillPassing(treadmill);
                            if (!a.passingTreadmill)
                                a.jump = a.run = 0; // убираем с препятствия
                            else
                                System.out.printf("%s успешно прошел препятствие!\n", a.name);
                        }
                    }
                }
            } while (count == marathons.length);
            System.out.printf("\n| FINISH");
            break;
        }
    }


    static Object generateMarathon() {

        int heightWall = random.nextInt(3) + 3; // массив для длины/высоты препятствий
        int longTreadmill = random.nextInt(3) + 3;
        int typeLet = random.nextInt(2); // рандомим препятствие
        switch (typeLet) {
            case 0:
                return new Wall(heightWall);
            case 1:
                return new Treadmill(longTreadmill);
        }
        return null;
    }


    static Participants generateParticipants() {
        String[] names = new String[] { "Дымок", "Уголек", "Апельсин", "Лисенок", "Персик", "Грей", "Сумрак" };

        int heightLength = random.nextInt(3) + 3; // рандомим высоту прыжка и длину бега
        int typeLet = random.nextInt(3); // рандомим участников

        switch (typeLet) {
            case 0:
                return new Human(names[random.nextInt(7)], heightLength, heightLength);
            case 1:
                return new Cat(names[random.nextInt(7)], heightLength, heightLength);
            case 2:
                return new Robot(names[random.nextInt(7)], heightLength, heightLength);
        }
        return null;
    }

}
