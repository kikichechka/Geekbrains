package com.geekbrains;

public class Main {
    public static void main(String[] args) {
        Employee [] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Иванов Иван Иванович","слесарь","ivan.@mail.ru",8800900,24000, 55);
        employeeArray[1] = new Employee("Петров Петр Петрович","специалист тех.обслуживания","petr.@mail.ru",8800900,24000,23);
        employeeArray[2] = new Employee("Васильев Евгений Васильевич","бухгалтер","evgeniy.@mail.ru",8800900,24000,36);
        employeeArray[3] = new Employee("Каратаев Сергей Сергеевич","экономист","sergey.@mail.ru",8800900,24000,41);
        employeeArray[4] = new Employee("Свистаев Олег Олегович","менеджер","oleg.@mail.ru",8800900,24000,37);

        for (int i = 0; i < employeeArray.length; i++){
            if(employeeArray[i].getAge() > 40)
                employeeArray[i].print();
        }
    }


}
