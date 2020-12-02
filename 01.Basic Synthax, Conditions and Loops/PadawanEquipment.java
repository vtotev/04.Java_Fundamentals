package BasicExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceLightsaber = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());

        int freeBelts = students / 6;

        double std = students * 1.0;
        std = std * 1.1;
        double neededMoney = (Math.ceil(std) * priceLightsaber) + (students * priceRobes) + ((students - freeBelts) * priceBelts);
        if (neededMoney > money)
            System.out.printf("Ivan Cho will need %.2flv more.%n", (neededMoney - money));
        else System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
    }
}
