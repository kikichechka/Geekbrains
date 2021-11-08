package com.geekbrains;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        task1();
        task2(0);
        task3();
        task4(5);
        task5();
        System.out.println(task6());
        task7(-2);
    }

    // 1-я задача
    public static void task1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 2-я задача
    public static void task2(int i) {
        int[] arr = new int[8];
        for (i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 3-я задача
    public static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 4-я задача
    public static void task4(int a) {
        int[][] arr = new int[a][a];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i== arr.length-1-j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 5-я задача**
    public static void task5 () {
        int [] arr = {2, 9, 23, 54, 10, 84, 43};
        Arrays.sort(arr);
        Arrays.toString(arr);
        int a = arr[0];
        int b = arr[arr.length-1];
        System.out.printf("Минимальное число- %d, максимальное число- %d.\n", a, b);
    }

    // 6-я задача**
    public static boolean task6 () {
        int sum = 0;
        int sum2 = 0;
        int a;
        int [] arr = {2, 2, 2, 1, 2, 2, 2, 10, 1, 2};
        for (int i = 0; i< arr.length; i++) {
            sum = sum + arr[i];//суммируем все значения в массиве
        }
        for (int j = arr.length-1; j>=0; j--) {
            sum2 = sum2 + arr [j];
            if (sum - sum2 == sum2) {
                return true;
            }
        }
        return  false;
    }
    // 7-я задача***
    public static void task7 (int n) {
        int[] arr = {1, 3, 99, 5, 7, 9, 23, 16, 56, 8};
        if (n >= 0) { //если n положительное
            for (int i = n; i < arr.length; i++) { //слева отсчитываем значение n, идем слева направо
                System.out.print(arr[i] + " ");
            }
            for (int j = 0; j < arr.length - (arr.length - n); j++) {
                System.out.print(arr[j] + " ");
            }
        } else { //если n отрицательное
            for (int i = arr.length+n-1; i < arr.length; i++) {// справа отнимаем значение n, идем слева направо
            System.out.print(arr[i] + " ");
        }
            for (int j = 0; j < arr.length + n - 1; j++) {
            System.out.print(arr[j] + " ");
            }
        }
    }
}
