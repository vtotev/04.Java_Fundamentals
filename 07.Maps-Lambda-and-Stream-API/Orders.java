package MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    static class Product {
        String name;
        int quantity = 0;
        double price = 0.0;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Product> products = new LinkedHashMap<>();
        while (!input.equals("buy")) {
            String[] cmd = input.split(" ");
            products.putIfAbsent(cmd[0], new Product());
            Product newValues = products.get(cmd[0]);
            newValues.setQuantity(newValues.getQuantity() + Integer.parseInt(cmd[2]));
            newValues.setPrice(Double.parseDouble(cmd[1]));
            products.put(cmd[0], newValues);
            input = scan.nextLine();
        }
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().getPrice() * entry.getValue().getQuantity());
            //System.out.printf("%s - %.2f - %d%n", entry.getKey(), entry.getValue().getPrice(), entry.getValue().getQuantity());
        }
    }
}
