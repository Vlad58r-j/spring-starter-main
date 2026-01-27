package com.t_bank;

import java.util.Scanner;

public class Roll {
    public static void main(String[] args) {
        System.out.print("Количество людей: ");
        int people = new Scanner(System.in).nextInt();

        System.out.println("Минимальное количество надрезов: " + cutsCount(people));
    }

    public static int cutsCount(int people) {
        int result = 0;
        while (people >= 2) {
            result++;
            people =  (int) Math.ceil((double) people / 2);//people % 2 != 0 ? : people / 2;
        }
        return result;
    }
}
