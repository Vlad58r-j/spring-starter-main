package com.t_bank;

import java.util.Scanner;
public class Tariff {

    public static void main(String[] args) {
        System.out.print("Цена тарифа: ");
        int price = new Scanner(System.in).nextInt();
        System.out.print("Размер тарифа: ");
        int internet = new Scanner(System.in).nextInt();
        System.out.print("Цена лишнего мегабайта: ");
        int priceMegaByte = new Scanner(System.in).nextInt();
        System.out.print("Размер интернет трафика : ");
        int usableInternet = new Scanner(System.in).nextInt();
        while (price >= 1 ){
                System.err.print("Неверная стоимость тарифа, введите число большее 1: ");
                price = new Scanner(System.in).nextInt();
            }
        while (usableInternet <= 100){
                System.err.print("Неверное значение используемого трафика, введите значение меньшее 100: ");
                usableInternet = new Scanner(System.in).nextInt();
            }

        var result = priceTariff(price, internet, priceMegaByte, usableInternet);
        System.out.println(result);
    }

    public static int priceTariff(int price, int internet, int priceMegaByte, int usableInternet) {
        int different = usableInternet > internet ? (usableInternet - internet) * priceMegaByte : internet;
        return price + different;
    }
}
