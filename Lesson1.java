package com.geekbrains;

public class Lesson1 {

    public static void main(String[] args) {
        byte byte1 = 123;
        short short1 = 32767;
        int int1 = 2147483647;
        long long1 = 92233720368L;
        float float1 = 1.34f;
        double double1 = 67.556;
        char char1 = '*';
        boolean boolean1 = true;

        System.out.println(task3(3.34f, 5.6f, 1.98f, 9.25f));
        System.out.println(task4(7,3));
        task5(-4);
        System.out.println(task6(-2));
        task7("Екатерина");
        task8(2012);
    }

    // 3-е задание
    public static float task3 (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // 4-е задание
    public static boolean task4 (int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // 5-е задание
    public static void task5 (int a) {
        if (a >= 0) {
            System.out.println("Число: " + a + " положительное.");
        } else {
            System.out.println("Число: " + a + " отрицательное.");
        }
    }

    // 6-е задание
    public static boolean task6 (int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    // 7-е задание
    public static void task7 (String name) {
        System.out.println("Привет, " + name + "!");
    }

    // 8-е звдание
    public static void task8 (int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " год високосный.");
        } else if (year % 4 == 0 && year % 400 == 0) {
            System.out.println(year + " год високосный.");
        } else {
            System.out.println(year + " год не високосный.");
        }
    }
}
