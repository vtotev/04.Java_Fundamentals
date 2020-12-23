package Methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(CheckGrade(Double.parseDouble(scan.nextLine())));
    }

    private static String CheckGrade(double grade) {
        String result = "";
        if (grade >= 2.0 && grade <= 2.99) result = "Fail";
        else if (grade >= 3.0 && grade <= 3.49) result = "Poor";
        else if (grade >= 3.5 && grade <= 4.49) result = "Good";
        else if (grade >= 4.5 && grade <= 5.49) result = "Very good";
        else if (grade >= 5.5 && grade <= 6.00) result = "Excellent";
        return result;
    }
}
