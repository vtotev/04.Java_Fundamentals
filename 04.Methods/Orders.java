package Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalcOrders(scan.nextLine(), Integer.parseInt(scan.nextLine()));
    }

    private static void CalcOrders(String order, int quantity) {
        double coffee = 1.50;
        double water = 1.00;
        double coke = 1.40;
        double snacks = 2.00;
        double price = 0.0;
        switch (order) {
            case "coffee":
                price = quantity * coffee;
                break;
            case "water":
                price = quantity * water;
                break;
            case "coke":
                price = quantity * coke;
                break;
            case "snacks":
                price = quantity * snacks;
                break;
        }
        System.out.printf("%.2f", price);
    }
}
