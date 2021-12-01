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
        }
        for (Participants a: participant) {
            System.out.printf(a + "%s, бегает %s м., прыгает на высоту %s м.!\n", a.name, a.run, a.jump);
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
                        if (a.run != 0 && a.jump != 0) {
                            if (o instanceof Wall) {// если препятствие стена
                                Wall wall = new Wall(((Wall) o).heightWall);
                                a.wallPassing(wall);
                                if (a.passing)  // если преодолел стену
                                    System.out.printf("%s успешно прошел препятствие!\n", a.name);
                                else
                                    a.jump = a.run = 0;
                            }
                            if (o instanceof Treadmill) {// если препятствие дорожка
                                Treadmill treadmill = new Treadmill(((Treadmill) o).longTreadmill);
                                a.treadmillPassing(treadmill);
                                if (a.passing)
                                    System.out.printf("%s успешно прошел препятствие!\n", a.name);
                                else
                                    a.jump = a.run = 0;
                            }
                        }
                    }
                }
            } while (count == marathons.length);
            System.out.printf("\n| FINISH");
            break;
        }
    }


    static Object generateMarathon() {

        int heightWall = random.nextInt(5) + 3; // массив для длины/высоты препятствий
        int longTreadmill = random.nextInt(5) + 3;
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

        int run = random.nextInt(5) + 3; // рандомим длину бега
        int jump = random.nextInt(5) + 3; // рандомим высоту прыжка
        int typeLet = random.nextInt(3); // рандомим участников

        switch (typeLet) {
            case 0:
                return new Human(names[random.nextInt(7)], run, jump);
            case 1:
                return new Cat(names[random.nextInt(7)], run, jump);
            case 2:
                return new Robot(names[random.nextInt(7)], run, jump);
        }
        return null;
    }

}
