package com.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson14 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 21, 5, 3, 1, 8));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 7, 6, 4, 2, 5, 7, 9, 0));
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 1, 1, 4, 4, 1, 4, 1};
        int[] arr3 = {1, 1, 1, 1};
        cutOff(list);
        cutOff(list1);
        System.out.println(examination(arr1));
        System.out.println(examination(arr2));
        System.out.println(examination(arr3));
    }


    public static List<Integer> cutOff(List<Integer> value) {
        int val = 0;
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i) == 4)
                val = ++i;
        }
        if (!value.contains(4)) {
            throw new java.lang.RuntimeException();
        }

        if (val != value.size()) {
            for (int i = val; i < value.size(); i++) {
                newList.add(value.get(i));
            }
            System.out.println(newList);
        }
        return newList;
    }

    public static boolean examination(int[] value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int o : value) {
            arrayList.add(o);
        }

        if (arrayList.contains(1) && arrayList.contains(4)) {
            for (int j : value) {
                if (j != 1 && j != 4)
                    return false;
            }
            return true;
        }
        return false;
    }
}


