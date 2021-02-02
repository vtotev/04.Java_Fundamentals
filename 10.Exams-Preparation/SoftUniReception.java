package ExamPrep;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = Integer.parseInt(scan.nextLine());
        int employee2 = Integer.parseInt(scan.nextLine());
        int employee3 = Integer.parseInt(scan.nextLine());
        int totalPeople = Integer.parseInt(scan.nextLine());
        int employeesPerHour = employee1+employee2+employee3;
        int hoursNeeded = 0;
        while (totalPeople > 0) {
            hoursNeeded++;
            if (hoursNeeded % 4 != 0)
                totalPeople -= employeesPerHour;
        }
        System.out.printf("Time needed: %dh.", hoursNeeded);

    }
}
