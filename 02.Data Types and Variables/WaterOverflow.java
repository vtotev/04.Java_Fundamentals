package DataTypesAndVars;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tankCapacity = 255;
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            int water = Integer.parseInt(scan.nextLine());
            if (water > tankCapacity) {
                System.out.println("Insufficient capacity!");
            } else {
                tankCapacity -= water;
            }
        }
        System.out.println((255 - tankCapacity));
    }
}
