package com.geekbrains.Lesson7;

public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public void infoFood () {
        System.out.printf("……………………………………………………………………………\nВ тарелке %s грамм корма.🥣" +
                "\n……………………………………………………………………………\n", food);
    }

    public boolean decreaseFood (int a) { //метод уменьшения еды
        if (food >= a) {
            food -= a;
            return true;
        }
        else
            return false;
    }
}
