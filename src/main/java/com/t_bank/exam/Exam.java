package com.t_bank.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {
        var value = new Scanner(System.in).next();
        var array = value.toCharArray();
        char prom;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    prom = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = prom;

                }
            }
        }
        System.out.println(Arrays.binarySearch(array, '0'));
        var result = Arrays.toString(array);
        System.out.println(result);

    }
}
