package Methods;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        switch (input) {
            case "int":
                int intInput = Integer.parseInt(scan.nextLine());
                System.out.println(dataTypePrint(intInput));
                break;
            case "real":
                double realInput = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f%n", dataTypePrint(realInput));
                break;
            case "string":
                String strInput = scan.nextLine();
                System.out.println(dataTypePrint(strInput));
                break;
        }
    }

    private static int dataTypePrint(int Input) {
        return Input * 2;
    }

    private static double dataTypePrint(double Input) {
        return Input * 1.5;
    }

    private static String dataTypePrint(String Input) {
        return "$" + Input + "$";
    }
}
