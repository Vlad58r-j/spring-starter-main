package com.t_bank;

import java.util.*;

public class SumNumber {

    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        var countValue = new Scanner(System.in).nextInt();

        System.out.print("Введите количество замен: ");
        var countChanges = new Scanner(System.in).nextInt();

        var sumValues = 0;
        List<Integer> values = new ArrayList<>(countValue - 1);
        for (int i = 0; i < countValue; i++) {
            System.out.print((i + 1) + " число: ");
            values.add(i, new Scanner(System.in).nextInt());
            sumValues += values.get(i);
        }

        var maxSum = 0;
        var countNumber = 0;
        for (int i = 0; i < values.size(); i++) {
            var currentValue = values.get(i);
            for (int j = 1; j < 10; j++) {
                var currentGap = (int) Math.pow(10, j);
                var first = (int) Math.pow(10, j - 1);
                if (currentValue >= first && currentValue < currentGap) {
                    values.set(i, (currentGap - 1) - currentValue);
                    maxSum += (currentGap - 1);
                    countNumber += j;
                    break;
                }
            }
        }

        if (countNumber < countChanges || maxSum == sumValues) {
            System.out.println("Сумма чисел поменяется на " + (maxSum - sumValues));
        } else {
            for (int i = 0; i < countChanges; i++) {
                values.sort(new ListSorted());
                var currentValue = values.get(0);
                for (int j = 1; j < 10; j++) {
                    var currentGap = (int) Math.pow(10, j);
                    var first = (int) Math.pow(10, j - 1);
                    if (currentValue >= first && currentValue < currentGap) {
                            values.set(0, currentValue - (currentValue / first) * first);
                            break;
                    }
                }
            }
            var resultSum = 0;
            for (Integer value : values) {
                resultSum += value;
            }
            System.out.println("После " + countChanges + " замен сумма всех чисел увеличилась: " + ((maxSum - resultSum) - sumValues));
        }
    }

    static class ListSorted implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}