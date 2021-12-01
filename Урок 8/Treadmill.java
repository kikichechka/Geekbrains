package com.geekbrains.Lesson8;

/**
 * класс беговая дорожка boolean метод прохождения дорожки
 */
public class Treadmill {
    protected int longTreadmill;

    public Treadmill(int longTreadmill) {
        this.longTreadmill = longTreadmill;
    }

    public boolean passing(int a) {
        if (longTreadmill <= a)
            return true;
        return false;
    }

    public String toString() {
        return String.format(" ⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚⁚ (%s м.)", longTreadmill);
    }
}
