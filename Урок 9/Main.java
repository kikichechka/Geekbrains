package com.geekbrains.Lesson9;

public class Main {
    static int sum;

    public static void main(String[] args) {

        try {
            String[][] array = new String[][]{{"1", "9", "6", "4"}, {"4", "2", "2", "7"}, {"2", "9", "1", "5"}, {"2", "1", "3", "8"}};
            arrayMethod(array);

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            System.out.printf("Сумма всех чисел равна %s.", sum);

        }
        catch (MyArraySizeException e) {
        }
        catch (MyArrayDataException e) {
        }
    }

    public static void arrayMethod (String[][]array) throws MyArraySizeException, MyArrayDataException {
        if(array.length > 4){
        throw new MyArraySizeException();
        }

        for(int i = 0; i < array.length; i++){
            if (array[i].length > 4) {
                throw new MyArraySizeException();
            }
            for(int j = 0; j < array.length; j++) {
                try {
                    sum = sum + Integer.parseInt(String.valueOf(array[i][j]));
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

    }
}

    class MyArraySizeException extends Exception {
    MyArraySizeException () {
        System.out.println("Размер массива не должен превышать 4 X 4!");
    }
    }
    class MyArrayDataException extends Exception {
    MyArrayDataException (int x, int y) {
        System.out.printf("В массиве находится недопустимый символ в ячейке %s x %s", x, y);
    }
    }