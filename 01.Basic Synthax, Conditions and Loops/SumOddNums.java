package com.company;

import java.util.Scanner;

public class SumOddNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        int oddCount = 0;
        int sum = 0;
        int numb = 0;
        while (oddCount < count) {
            numb++;
            if (numb % 2 != 0) {
                System.out.println(numb);
                sum += numb;
                oddCount++;
            }
        }
        System.out.println("Sum: " + sum);
    }
}
