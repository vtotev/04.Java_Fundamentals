package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

    static class Food {
        String foodName;
        String date;
        int callories;

        public Food(String foodName, String date, int callories) {
            this.foodName = foodName;
            this.date = date;
            this.callories = callories;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCallories() {
            return callories;
        }

        public void setCallories(int callories) {
            this.callories = callories;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Food> foodList = new ArrayList<>();
        String regex = "(#|\\|)([A-Za-z ]+)\\1(\\d+\\/\\d+\\/\\d{2})\\1(\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int totalCalls = 0;
        while (matcher.find()) {
            String foodName = matcher.group(2);
            String expDate = matcher.group(3);
            int callories = Integer.parseInt(matcher.group(4));
            Food food = new Food(foodName, expDate, callories);
            totalCalls += callories;
            foodList.add(food);
        }
        int days = 0;
        if (totalCalls != 0) {
            days = Math.floorDiv(totalCalls, 2000);
        }

        System.out.printf("You have food to last you for: %d days!%n", days);
        for (int i = 0; i < foodList.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", foodList.get(i).getFoodName(),
                    foodList.get(i).getDate(), foodList.get(i).getCallories());
        }
    }
}
