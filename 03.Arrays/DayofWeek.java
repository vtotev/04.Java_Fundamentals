package Arrays;

import java.util.Scanner;

public class DayofWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dayNum = Integer.parseInt(scan.nextLine());
        if (dayNum >= 1 && dayNum <=7) {
            System.out.println(days[dayNum-1]);
        } else System.out.println("Invalid day!");
    }
}
