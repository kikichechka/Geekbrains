package com.geekbrains.Lesson8;

/**
 * класс стена
 * <p>
 * boolean метод прохождения стены
 */
public class Wall {
    public int heightWall;

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }

    public boolean passing(int a) {
        if (heightWall <= a)
            return true;
        return false;
    }

    public String toString() {
        return String.format("|‾‾‾‾‾‾| (%s м.)", heightWall);
    }

}
