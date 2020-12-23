package Methods;

import java.util.Scanner;

public class GreaterofTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputType = scan.nextLine();
        switch (inputType) {
            case "int":
                int firstNum = Integer.parseInt(scan.nextLine());
                int secondNum = Integer.parseInt(scan.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstCh = scan.nextLine().charAt(0);
                char secondCh = scan.nextLine().charAt(0);
                System.out.println(getMax(firstCh, secondCh));
                break;
            case "string":
                String firstStr = scan.nextLine();
                String secondStr = scan.nextLine();
                System.out.println(getMax(firstStr, secondStr));
                break;
        }
    }

    private static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) return firstNum;
        else return secondNum;
    }

    private static char getMax(char firstCh, char secondCh) {
        if (firstCh > secondCh) return firstCh;
        else return secondCh;
    }
    private static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) > 0) return firstStr;
        else return secondStr;
    }
}
