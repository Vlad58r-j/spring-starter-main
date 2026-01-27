package com.t_bank;

import java.util.*;
//заменил List na Map!!
public class Ladder {

    public static void main(String[] args) {
        System.out.print("Количество сотрудников: ");
        int countEmployee = new Scanner(System.in).nextInt();

        System.out.print("Время до ухода первого сотрудника: ");
        int timeForFirstEmployee = new Scanner(System.in).nextInt();

        Map<Integer, Integer> floor = new HashMap();
        for (int i = 0; i < countEmployee; i++) {
            System.out.print("Этаж " + (i + 1) + " сотрудника: ");
            floor.put(i, new Scanner(System.in).nextInt());
        }
        System.out.print("Какой сотрудник первый уйдет: ");
        int personWhoFirstGoOut = new Scanner(System.in).nextInt();

        var maxFloor = floor.get(countEmployee - 1);
        var differentLastAndFirst = maxFloor - floor.get(0);
        var employeePosition = floor.get(personWhoFirstGoOut - 1);
        int result;
        if ((employeePosition - timeForFirstEmployee <= floor.get(0)) || (maxFloor - employeePosition <= floor.get(0))) {
            result = differentLastAndFirst;
        } else {
            if (employeePosition < maxFloor / 2) {
                result = employeePosition - floor.get(0) + differentLastAndFirst;
            } else if (employeePosition > maxFloor / 2) {
                result = maxFloor - employeePosition + differentLastAndFirst;
            } else {
                result = maxFloor - floor.get(0) + (maxFloor - floor.get(0)) / 2;
            }
        }

        System.out.println(result);

    }
}