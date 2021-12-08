package com.geekbrains;

import java.util.*;

public class Lesson10 {
    private static Scanner scanner = new Scanner(System.in);
    static String answer;

    public static void main(String[] args) {

        // 1-я задача
        List<String> worlds = Arrays.asList("Кот", "Собака", "Обезьяна", "Лев", "Собака", "Сурикат", "Обезьяна", "Лев", "Питон", "Хомяк", "Попугай", "Лев");
        Map<String, Integer> worldsAnimas = new HashMap<>();
        Set<String> unique = new HashSet<>(worlds);

        System.out.println("Коллекция:");
        for (String o : worlds)
            System.out.print(o + " ");


        System.out.println("\n***********************" +
                "\nСтатистика каждого элемента:");
        for (String s : worlds) {
            worldsAnimas.put(s, worldsAnimas.getOrDefault(s, 0) + 1);
            //коллекция.ключ-значение(ключ, коллекция.значение
        }
        System.out.print(worldsAnimas.entrySet());


        System.out.println("\n***********************" +
                "\nСписок уникальных элементов: ");
        for (String b : unique) {
            System.out.print(b + " ");
        }
        System.out.print("\n\n\n");


        String[] phoneBook = {
                "Иванов Николай +79324500999",
                "Сидоров Сергей +79003451267",
                "Свистов Иван +79017651267",
                "Андреев Роман +73451238908",
                "Мишурина Светлана +79207894518",
                "Костюков Анатолий +79103459317",
                "Сидорова Наталья +79093171267",
                "Кошкина Анастасия +79083401167",
                "Малышев Юрий +79031873434",
                "Иванов Павел +79997654565",
                "Красильников Илья +79119806070",
                "Андреев Константин +79167893242"};

        System.out.print("Телефонный справочник.\n" +
                "***********************\n");
        while (true){
            searchNumber(phoneBook);
        }
    }


    // 2-я задача
    static class PhoneBook {
        String LastName;
        String FirstName;
        String number;

        public PhoneBook(String lastName, String firstName, String number) {
            this.LastName = lastName;
            this.FirstName = firstName;
            this.number = number;
        }
    }

    static class newPhoneBook extends PhoneBook{

        public newPhoneBook(String lastName, String firstName, String number) {
            super(lastName, firstName, number);
        }
        @Override
        public String toString() {
            return String.format("%s %s %s", LastName, FirstName, number);
        }
    }

    static void searchNumber(String[] phoneBook) {
        ArrayList<newPhoneBook> newPhoneBook = new ArrayList<>(0);
        System.out.print("Введите фамилию для поиска >>>> ");
        answer = scanner.next();

            for (String o : phoneBook) {
                String[] parts = o.split(" ");
                String key = (parts[0]);
                
                if (answer.equals(key))
                    newPhoneBook.add(new newPhoneBook(parts[0], parts[1], parts[2]));
            }
            if (newPhoneBook.size() != 0)
                System.out.println(newPhoneBook);
            else
                System.out.printf("Контакт с фамилией %s не найден.\n", answer);
    }
}
