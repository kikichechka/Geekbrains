package com.geekbrains.Lesson8;

abstract class Participants {
    public boolean passing = false;
    public String name;
    public int run;
    public int jump;



    public Participants(String name, int run, int jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    public void wallPassing(Wall w) {
        if (w.passing(jump))
            passing = true;
        else
            passing = false;
    }
    public void treadmillPassing(Treadmill t) {
        if (t.passing(run))
            passing = true;
        else
            passing = false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * класс человек
 */
class Human extends Participants {
    public Human(String name, int run, int jump) {
        super(name, run, jump);
    }

    @Override
    public String toString() {
        return String.format("👦 ");
    }
}

/**
 * класс кот
 */
class Cat extends Participants {
    public Cat(String name, int run, int jump) {
        super(name, run, jump);
    }

    @Override
    public String toString() {
        return String.format("🐈 ");
    }
}

/**
 * класс робот
 */
class Robot extends Participants {
    public Robot(String name, int run, int jump) {
        super(name, run, jump);
    }

    @Override
    public String toString() {
       return String.format("🤖 ");
    }
}



