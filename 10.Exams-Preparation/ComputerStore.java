package ExamPrep;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0.0;
        String input = scan.nextLine();
        while (true) {
            if (input.equals("regular") || input.equals("special")) {
                break;
            }
            double price = Double.parseDouble(input);
            if (price <= 0.0) {
                System.out.println("Invalid price!");
            } else {
                sum += price;

            }
            input = scan.nextLine();
        }
        if (sum == 0) {
            System.out.println("Invalid order!");
            return;
        }
        double taxes = sum * 0.2;
        double totalSum = sum * 1.2;
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", sum);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        if (input.equals("special")) {
            totalSum *= 0.9;
        }
        System.out.printf("Total price: %.2f$%n", totalSum);
    }
}
