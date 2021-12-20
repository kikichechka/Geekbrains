package com.geekbrains;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.Arrays;

public class Lesson13 {
    public static final int CARS_COUNT = 4;
    int index = 0;

    public static void main(String[] args) {
        int index = 0;
        SyncObj syncObj = new SyncObj();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Track track = new Track(new Road(), new Tunnel(), new Road());
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(syncObj, track, 20 + (int) (Math.random() * 10), i+1);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        //System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        //System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    /*public void az() {
        try {
            MON.wait();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/
    public static class SyncObj{

        // Вспомогательный счетчик для учета подготовки автомобилей и победителей соревнования
        int counter = 0;

        synchronized void preparing(){

            try
            {
                if (++counter == CARS_COUNT) {
                    notifyAll();
                    counter = 0; // Сбрасываем счетчик перед началом гонки
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                }
                else
                    wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        synchronized void checkFinish(String name){

            if (counter++ == 0){
                System.out.printf("У нас есть победитель 🥇 : %s \n" +
                        "-----------------------------------\n", name);

            } else {
                System.out.println(name + " пришел " + counter + "м!");
            }
            if (counter == CARS_COUNT)
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        }

    }
}


    /**
     * участник гонки
     */
    class Car implements Runnable {
        private int CARS_COUNT; // счетчик
        private Track track; // массив трассы
        private int speed;  // скорость
        private String name; // имя
        private Lesson13.SyncObj syncObj;

        public Car(Lesson13.SyncObj syncObj, Track track, int speed, int CARS_COUNT) {
            this.syncObj = syncObj;
            this.CARS_COUNT = CARS_COUNT;
            this.track = track;
            this.speed = speed;
            this.name = "Участник №" + CARS_COUNT;
        }

        public String getName() { return name; }
        public int getSpeed() { return speed; }


        @Override
        public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                syncObj.preparing();
            } catch (Exception e) {
                e.printStackTrace();
            }
                for (int i = 0; i < track.stages.size(); i++) {
                    track.stages.get(i).go(this);
                }
            syncObj.checkFinish(name);
        }
    }

    /**
     * тоннель
     */
    class Tunnel extends Stage {

        public Tunnel() {
            this.length = 50;
            this.stageName = "Тоннель " + length + " метров";
        }

        @Override
        protected void go(Car c) {
            synchronized (c) {
                try {
                    System.out.printf("%s готовится к этапу: %s.\n", c.getName(), stageName);
                    System.out.printf("%s начал этап: %s.\n", c.getName(), stageName);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally{
                    System.out.printf("%s прошел этап: %s.\n", c.getName(), stageName);
                }
            }
        }
    }

    /**
     * дорога
     */
    class Road extends Stage {
        public Road() {
            this.length = 100;
            this.stageName = "Дорога " + length + " метров";
        }

        @Override
        protected void go(Car c) {
            try {
                System.out.printf("%s готовится к этапу: %s.\n", c.getName(), stageName);
                System.out.printf("%s начал этап: %s.\n", c.getName(), stageName);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("%s прошел этап: %s.\n", c.getName(), stageName);
            }
        }
    }


    /**
     * этапы прохождения гонки
     */
    abstract class Stage {
        protected int length;
        protected String stageName;

        public String getStageName() { return stageName;}
        protected abstract void go (Car c);
    }

    /**
     * трасса
     */
    class Track {
        public ArrayList<Stage> stages;

        public Track(Stage... stages) {
            this.stages = new ArrayList<>(Arrays.asList(stages));
        }
}
