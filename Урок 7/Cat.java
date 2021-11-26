package com.geekbrains.Lesson7;

class Cat {
    public String name;
    public int appetite;
    public boolean satiety = false; // сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        printCat();
    }
    public void printCat() {
        System.out.printf("🐈 Котик %s, голоден. Ему необходимо съесть %s грамм корма.\n", name, appetite);
    }

    public void eat (Plate p) { //метод поедания еды из тарелки
        if (p.decreaseFood(appetite)) //если колличество еды уменьшилось
            satiety = true; // сытость правда
    }
}