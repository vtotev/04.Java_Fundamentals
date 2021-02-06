package com.company;

import java.util.Scanner;

public class Student_Information {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        float grade = Float.parseFloat(scan.nextLine());
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name,age,grade);
    }
}
