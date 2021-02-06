package com.company;

import java.util.Scanner;

public class MultiplicationTableV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int multipl = Integer.parseInt(scan.nextLine());

        if (multipl > 10) {
            System.out.printf("%d X %d = %d%n", num, multipl, (num * multipl));
        } else
        {
            for (int i = multipl; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", num, i, (num * i));
        }
        }
    }
}
