package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    static class Furnitures {
        String name;
        double price;
        int quantity;

        public Furnitures(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(>{2})(?<name>[A-Za-z]+)(<{2})(?<price>[0-9.]+)(!{1})(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scan.nextLine();
        List<Furnitures> furnituresList = new ArrayList<>();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String furnitureName = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                Furnitures newFurniture = new Furnitures(furnitureName, price, quantity);
                furnituresList.add(newFurniture);
            }
            input = scan.nextLine();
        }
        double totalSun = 0.0;
        System.out.println("Bought furniture:");
        for (Furnitures item : furnituresList) {
            totalSun += (item.getPrice() * item.getQuantity());
            System.out.printf("%s%n", item.getName());
        }
        System.out.printf("Total money spend: %.2f", totalSun);
    }
}
