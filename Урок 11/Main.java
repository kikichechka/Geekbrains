package com.geekbrains.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.printf
                ("\n»»»»»»»»»»»»»»»»» Task_1 «««««««««««««««««\n");
        String[] arrString = {"cat", "1234", "1dgu5", "186.8"};
        Integer[] arrInteger = {123, 678, 908, 543};
        changeElements(arrInteger, 1, 2);
        changeElements(arrString, 2,3);

        System.out.printf
                ("\n»»»»»»»»»»»»»»»»» Task_2 «««««««««««««««««\n");
        transformation(arrInteger);
        transformation(arrString);



        System.out.printf
                ("\n»»»»»»»»»»»»»»»»» Task_3 «««««««««««««««««\n");

        Box<Orange> orangeBox_1 = new Box("для апельсинов № 1");
        Box<Orange> orangeBox_2 = new Box("для апельсинов № 2");
        Box<Apple> appleBox_1 = new Box("для яблок № 1");

        Orange orange = new Orange(4);
        orangeBox_1.addAndPrintFruits(orange);


        Orange orange1 = new Orange(4);
        orangeBox_2.addAndPrintFruits(orange1);


        Apple apple = new Apple(1);
        appleBox_1.addAndPrintFruits(apple);


        System.out.println(orangeBox_1.compare(orangeBox_2));
        System.out.println(orangeBox_2.compare(appleBox_1));

        orangeBox_1.empty(orangeBox_2);

    }

    //task_1
    public static <K> void changeElements(K[] value, int a, int b) {
        System.out.printf("Начальный массив:\n%s\n", Arrays.toString(value));
        K element = value[a - 1];
        value[a - 1] = value[b - 1];
        value[b - 1] = element;
        System.out.printf("Поменяем местами %s и %s элементы:\n%s\n", a, b, Arrays.toString(value));
    }

    //task_2
    public static <K> void transformation (K[] value) {
        ArrayList <K> newList = new ArrayList<>();
        for (K o: value) {
            newList.add(o);
        }
        System.out.printf("Массив преобразован в ArrayList %s\n", newList);
    }
}
