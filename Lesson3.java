package com.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        int task = 0;
        do {
            System.out.printf("==============================\n" +
                    "Введите номер задачи (1 или 2):\n");
            task = scanner.nextInt();
            switch (task) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
            }
        } while (true);
    }

    // 1-я задача
    public static void task1() {
        int restart;
        do {
            int hiddenNumber = random.nextInt(10);
            int number = 0;
            System.out.println("------------------------------\n" +
                    "Игра: угадай число.\n" +
                    "Компьютер загадал число от 0 до 9 включительно.\n");


            for (int i = 1; i <= 3; i++) {
                System.out.println("Попытка №" + i + ". Введите число:");
                number = scanner.nextInt();
                if (hiddenNumber == number) {
                    System.out.println("Вы угадали! Загаданное число:" + hiddenNumber);
                    break;
                } else if (hiddenNumber > number) {
                    System.out.println("Вы не угадали, загаданное число больше.");
                } else {
                    System.out.println("Вы не угадали, загаданное число меньше.");
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).");
            restart = scanner.nextInt();
        } while (restart == 1);
    }

    // 2-я задача
    public static void task2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("------------------------------\n" +
                "Игра угадай слово.\n" +
                "Компьютер загадал одно из этих слов: ");
        for (String o : words)
            System.out.print(o + ", ");

        int number = random.nextInt(25); // компьютер загадывает число от 0 до 24
        String hiddenWord = words[number];// в переменную hiddenWord записываем загаданное слово
        String[] newHiddenWord = hiddenWord.split(""); //разбиваем загаданное слово на массив символов, для получения его длины
        String answer;


        do {
            int a = 0;
            System.out.println("Введите слово с маленькой буквы на латинице:");
            answer = scanner.next();
            String[] newAnswer = answer.split("");//разбиваем введенное слово на массив, для получения его длины


            if (answer.equals(hiddenWord)){
                break;
            }
            for (int i = 0; i < 15; i++) { //цикл 15-ти символов
                if (a < newAnswer.length && a < newHiddenWord.length &&
                        hiddenWord.charAt(a) == answer.charAt(a)) { // если первые стмволы равны
                    System.out.print(hiddenWord.charAt(a));
                    a++;
                } else {
                    System.out.print("#");
                }
            }
            System.out.println(" Вы не угадали!");
        } while (true);
        System.out.println("Поздравляем, Вы выиграли!");
    }
}

