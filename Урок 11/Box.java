package com.geekbrains.Lesson11;

import java.util.ArrayList;
import java.util.List;

//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
class Box<T extends Fruits> {
    public String boxName;
    private List<T> list;
    public float weight;

    public Box(String boxName) {
        this.boxName = boxName;
        this.weight = weight;
        list = new ArrayList<T>();
    }

    void add2 (T object) {
        list.add(object);
    }

    public void empty (Box<T> box) {
        System.out.printf("\n📦 -> 📦 Пересыпали все %s из коробки %s в коробку %s.\n"
                , list.get(0).toString(), this.boxName, box.boxName);
        for (T o: list) {
            box.add2(o);
        }
        list.clear();
        System.out.printf("Теперь в коробке %s находятся %s в колличестве: %s шт.\n", box.boxName, box.list.get(0).toString(), box.list.size());
    }

    void addAndPrintFruits(T object) { // добавляем фрукты в коробку и выводим информацию в консоль
        for (int i = 0; i < object.number; i++)
            list.add(object);
        if (list.isEmpty())
            System.out.println("📦❌Коробка пуста");
        else
            System.out.printf("📦 В коробке %s находятся %s в количестве %s шт. Вес коробки составляет %f кг.\n"
                    , boxName, list.get(0).toString(), list.size(), getWeight());
    }


    public float getWeight() {
        weight = (list.size() * T.weight) / 1000;
        return weight;
    }

    boolean compare(Box<? extends Fruits> box) {
        System.out.printf("\n📦 ⚖ 📦 Сравним вес коробки %s и коробки %s: ", this.boxName, box.boxName);
        return this.getWeight() == box.getWeight();
    }
}