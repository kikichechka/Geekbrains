package com.geekbrains;

public class Employee {

    private String name;
    private String position;
    private String email;
    private int telephone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, int telephone,
                    int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
        setAge(age);

    }
    void print () {
        System.out.printf("ФИО сотрудника = %s, должность = %s, email = %s, телефон = %s, " +
                "зарплата = %s рублей в месяц, возраст = %s", name, position, email, telephone, salary, getAge());
        System.out.println();
    }
    public void setAge(int age) {
        if (age < 40) {
            System.out.println("Сотрудники младше 40 лет не выводятся в программе.");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }


}

