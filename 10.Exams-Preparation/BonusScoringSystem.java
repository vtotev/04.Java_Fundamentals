package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scan.nextLine());
        int lecturesCount = Integer.parseInt(scan.nextLine());
        int courseBonus = Integer.parseInt(scan.nextLine());
        List<Integer> studentAttendancies = new ArrayList<>();
        List<Double> studentTotalBonus = new ArrayList<>();
        for (int i = 0; i < studentsCount; i++) {
            int studAtt = Integer.parseInt(scan.nextLine());
            studentAttendancies.add(studAtt);
            double bonusPoints = ((double)studAtt / lecturesCount) * (5 + courseBonus);
            studentTotalBonus.add(bonusPoints);
        }
        double score = 0.0;
        int index = -1;
        for (int i = 0; i < studentTotalBonus.size(); i++) {
            if (studentTotalBonus.get(i) > score) {
                score = studentTotalBonus.get(i);
                index = i;
            }
        }
        if (index != -1) {
            System.out.printf("Max Bonus: %.0f.%n", Math.ceil(studentTotalBonus.get(index)));
            System.out.printf("The student has attended %d lectures.", studentAttendancies.get(index));
        } else {
            System.out.println("Max Bonus: 0.");
            System.out.println("The student has attended 0 lectures.");

        }
    }
}
