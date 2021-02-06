package com.company;

import java.util.Scanner;

public class BackInThirty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int min = Integer.parseInt(scan.nextLine());
        min += 30;
        if (min >= 60) {
            min -= 60;
            hour++;
        }
        if (hour > 23) {
            hour -= 24;
        }
        System.out.printf("%d:%02d", hour, min);
    }
}
