package com.geekbrains;

public class Lesson12 {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    final static float[] arr1 = new float[SIZE];
    final static float[] arr2 = new float[SIZE];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();

        // посмотреть что высчитывает формула)
        /*for (int i=0; i< arr2.length;i++) {
            System.out.println(arr2[i]);
            if (i == 10)
                break;
        }*/
    }

    public static float[] calculations (float[] arr) { //метод вычисления по формуле
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        return arr;
    }


    public static void firstMethod() {
        for (int i = 0; i < arr1.length; i++) arr1[i] = 1.0f; // заполнили массив единицами
        //Arrays.fill(arr1, 1.0f); //компилятор подсказал как заменить цикл for
        long a = System.currentTimeMillis();
        calculations(arr1);
        System.out.printf("Время работы первого метода: %s мс.\n", System.currentTimeMillis() - a);
    }

    public static void secondMethod() {
        float[] firstHalf = new float[HALF]; // 1-я половина массива arr2
        float[] secondHalf = new float[HALF]; // 2-я половина массива arr2
        for (int i = 0; i < arr2.length; i++) arr2[i] = 1.0f; // заполнили весь массив единицами
        //Arrays.fill(arr2, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, firstHalf, 0, HALF);
        System.arraycopy(arr2, 0, secondHalf, 0, HALF);


        new Thread() { //1-й поток работает над 1-й половиной массива
            public void run() {
                calculations(firstHalf);
            }
        }.start(); // new Thread(() -> calculations(firstHalf)).start();

        new Thread() {//2-й поток работает над 2-й половиной массива
            public void run() {
                calculations(secondHalf);
            }
        }.start();
        System.arraycopy(firstHalf, 0, arr2, 0, HALF);
        System.arraycopy(secondHalf, 0, arr2, HALF, HALF);
        System.out.printf("Время работы второго метода: %s мс.", System.currentTimeMillis() - a);
    }
}
