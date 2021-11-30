package com.geekbrains.Lesson8;

abstract class Participants {
    public boolean passingTreadmill = false;
    public boolean passingWall = false;
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
            passingWall = true;
    }
    public void treadmillPassing(Treadmill t) {
        if (t.passing(run))
            passingTreadmill = true;
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
    public void setName(String name) {
        System.out.print("👦 %s" + name);
    }

    @Override
    public String toString() {
        return String.format("👦 %s, прыгает на высоту %s м., бегает %s м.!", name, jump, run);
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
        return String.format("🐈 %s, прыгает на высоту %s м., бегает %s м.!", name, jump, run);
    }

    @Override
    public void setName(String name) {
        System.out.printf("🐈 %s", name);
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
        return String.format("🤖 %s, прыгает на высоту %s м., бегает %s м.!", name, jump, run);
    }

    @Override
    public void setName(String name) {
        System.out.printf("🤖 %s", name);
    }
}



