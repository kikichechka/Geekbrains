package com.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static int SIZE_FIELD = 4; //размер поля
    public static int SIZE_GAME_FIELD = 4; // размер игрового поля
    public static final int NUMBER_OF_STROKES = 3; //количество ходов для выигрыша
    public static final char EMPTY_FIELD = '•'; // пустая клетка
    public static final char DOT_X = 'x'; // ход х
    public static final char DOT_O = 'o'; // ход 0
    public static int FIRST_MOVE = 0; //первый ход
    public static char[][] field; // массив поля
    public static Scanner sc = new Scanner(System.in); // считывание консоли
    public static Random rand = new Random(); // рандомные числа
    public static int i, j;
    public static int x, y;



    public static void main(String[] args) {
        System.out.println("______ Игра: Крестики-нолики _____");
        initMap(); //наметили карту
        printMap(); // нарисовали карту
        chooseMove(); // выбрали фигуру

        while (true) {
            playGame();
            if (!chekVictory(DOT_X)) {
                if (FIRST_MOVE == 1) {
                    System.out.println("Поздравляем, Вы выиграли!!!");
                }
                if (FIRST_MOVE == 2) {
                    System.out.println("К сожалению Вы проиграли :(, выиграл искуственный интеллект!");
                }
                break;
            }
            if (!chekVictory(DOT_O)) {
                if (FIRST_MOVE == 1) {
                    System.out.println("К сожалению Вы проиграли :(, выиграл искуственный интеллект!");
                }
                if (FIRST_MOVE == 2) {
                    System.out.println("Поздравляем, Вы выиграли!!!");
                }
                break;
            }
            if (!emptyField()) {
                printMap();
                System.out.println("---- Ничья! ----");
            }
        }

        do {
            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет) ---> ");
            int answer = sc.nextInt();
            if (answer == 1)
                main(args);
            if (answer == 0)
                System.out.println("--------- Конец игры ---------");
                break;
        } while (true);
    }


    public static void initMap() { //наметили карту
        field = new char[SIZE_GAME_FIELD][SIZE_GAME_FIELD];
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                field[i][j] = EMPTY_FIELD;
            }
        }
    }


    public static void printMap() { // нарисовали карту
        for (int i = 0; i <= SIZE_FIELD; i++) { // напечатали горизонталь
            System.out.print(i + "  ");
        }
        for (int i = 0; i < SIZE_FIELD; i++) { // напечатали вертикаль
            System.out.println(); // перешли на слндующую строку
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                System.out.print("|" + field[i][j] + "|");
            }
        }
        System.out.println("\n__________________________________");
    }


    public static void chooseMove() { //выбор фигуры
        System.out.print("Укажите, какой фигурой будете играть, X или 0: ---> ");
        String answer = sc.nextLine();
        if (answer.equals("x") || answer.equals("X")
                || answer.equals("х") || answer.equals("Х")) {
            FIRST_MOVE = 1; // если человек ходит х, присваиваем переменной параметр 1
        } else if (answer.equals("o") || answer.equals("O")
                || answer.equals("о") || answer.equals("О")
                || answer.equals("0")) {
            FIRST_MOVE = 2; // если человек ходит 0, присваиваем переменной параметр 2
        } else {
            System.out.println("Введена некорректная фигура.");
            chooseMove();
        }
    }


    public static void playGame() { //процесс игры
        switch (FIRST_MOVE) {
            case 1: // если человек ходит х, его ход первый
                do {
                    System.out.print("Укажите координаты хода (Х и У): ---> ");
                    x = sc.nextInt();
                    y = sc.nextInt();
                } while (!isSellValid(x - 1, y - 1)); // проверяем возможность хода
                field[y - 1][x - 1] = DOT_X;


                while (emptyField() || !chekVictory(DOT_X)) { // если есть пустые поля и предыдущий ход не выигрышный
                        do {
                            x = rand.nextInt(SIZE_GAME_FIELD + 1);// компьютер рандомит число от 0 до числа, равной размеру карты включительно
                            y = rand.nextInt(SIZE_GAME_FIELD + 1);
                        } while (!isSellValid(x - 1, y - 1)); // проверяем возможность хода и наличие выигрышной комбинации у предыдущего хода
                        field[x - 1][y - 1] = DOT_O;
                        printMap();
                        break; // для выхода из цикла после каждого хода компьютера
                    }
                break;


            case 2: // если человек ходит 0, первый ход компьютера
                do {
                    x = rand.nextInt(SIZE_GAME_FIELD + 1); // компьютер рандомит число от 0 до числа, равной размеру карты включительно
                    y = rand.nextInt(SIZE_GAME_FIELD + 1);
                } while (!isSellValid(x - 1, y - 1)); // проверяем возможность хода
                field[y - 1][x - 1] = DOT_X;
                printMap();


                while (emptyField() || !chekVictory(DOT_O)) { // Проверяем полную заполненность поля и выигрышные комбинации
                    do {
                        System.out.print("Укажите координаты хода (Х и У): ---> ");
                        x = sc.nextInt();
                        y = sc.nextInt();
                    } while (!isSellValid(x - 1, y - 1)); // проверяем возможность хода
                    field[y - 1][x - 1] = DOT_O;
                    break; // выходим из цикда после каждого хода человека
                }
                printMap();
                break;
        }
    }

    public static boolean isSellValid(int x, int y) { //проверка хода
        if (x < 0 || x >= SIZE_GAME_FIELD || y < 0
                || y >= SIZE_GAME_FIELD || field[y][x] != EMPTY_FIELD) { // проверка введенных координат в заданном диапазоне и наличие пустой клетки
            return false;
        }
        return true;
    }


    public static boolean emptyField() { //проверка пустого поля
        for (int i = 0; i < SIZE_GAME_FIELD; i++) {
            for (int j = 0; j < SIZE_GAME_FIELD; j++) {
                if (field[i][j] == EMPTY_FIELD) { //если есть пустое поле возвращаем правду
                    return true;
                }
            }
        }
        return false;
    }



    public static boolean chekVictory(char symbol) { // проверка победы
        int a = 0; // счетчик ходов для выигрыша
        int n = SIZE_GAME_FIELD*2 - 3; //для работы с горизонталями "/"
        int n1 = SIZE_GAME_FIELD - 2; // для работы с горизонталями "\"

        // --------проверяем горизонталь " - "-----------
        for (i = 0; i < SIZE_GAME_FIELD; i++) {
            for (j = 0; j < SIZE_GAME_FIELD; j++) {
                if (field[i][j] == symbol) {
                    a++; //если стоит на клетке символ, приращиваем к счетчику 1
                } else {
                    a = 0; //если символа нет, обнуляем счетчик
                }
                if (a == NUMBER_OF_STROKES)  // если счетчик равен количеству ходов для выигрыша- победа
                    return false;
            }
        }

        // ---------проверяем вертикаль " | " -----------
        for (i = 0; i < SIZE_GAME_FIELD; i++) {
            for (j = 0; j < SIZE_GAME_FIELD; j++) {
                if (field[j][i] == symbol)
                    a++; //если стоит на клетке символ, приращиваем к счетчику 1
                else
                    a = 0; //если символа нет, обнуляем счетчик

                if (a == NUMBER_OF_STROKES)  // если счетчик равен количеству ходов для выигрыша- победа
                    return false;
            }
        }

        // --------- проверяем все диагонали " /// "----------
        while (n >= 1) {
            for (i = 0; i < SIZE_GAME_FIELD; i++) {
                for (j = 0; j < SIZE_GAME_FIELD; j++) {
                    if (i + j == n) {
                        if (field[i][j] == symbol)
                            a++; //если стоит на клетке символ, приращиваем к счетчику 1
                        else
                            a = 0;
                        if (a == NUMBER_OF_STROKES)  // если счетчик равен количеству ходов для выигрыша- победа
                            return false;
                    }
                }
            }
            n--;
        }

        // --------- проверяем все диагонали " \\\ "----------
        while (n1 >= -SIZE_GAME_FIELD + 2) { // пока n больше чем (минус длинна поля) плюс 2
            for (i = 0; i < SIZE_GAME_FIELD; i++) {
                for (j = 0; j < SIZE_GAME_FIELD; j++) {
                    if (i + n1 == j) {
                        if (field[i][j] == symbol)
                            a++; //если стоит на клетке символ, приращиваем к счетчику 1
                        else
                            a = 0;
                        if (a == NUMBER_OF_STROKES)  // если счетчик равен количеству ходов для выигрыша- победа
                            return false;
                    }
                }
            }
            n1--;
        }
        return true;
    }
}


