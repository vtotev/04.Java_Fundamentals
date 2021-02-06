package com.company;

import java.util.Scanner;

public class TheatherPromos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dayType = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int price = -1;

        switch (dayType.toLowerCase()) {
            case "weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                } else if (age > 64 && age <= 122) {
                    price = 12;
                } else price = -1;
                break;

            case "weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                } else if (age > 64 && age <= 122) {
                    price = 15;
                } else price = -1;
                break;

            case "holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                } else price = -1;
                break;
        }
        if (price == -1) {
            System.out.println("Error!");
        } else System.out.printf("%d$", price);
    }
}
