package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> drums = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsInitialQuality = new ArrayList<>();
        for (int i = 0; i < drums.size(); i++) {
            drumsInitialQuality.add(drums.get(i));
        }
        String input = scan.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drums.size(); i++) {
                drums.set(i, (drums.get(i) - hitPower));
                if (drums.get(i) <= 0) {
                    double cost = drumsInitialQuality.get(i) * 3.0;
                    if (savings - cost > 0) {
                        drums.set(i, drumsInitialQuality.get(i));
                        savings -= cost;
                    } else {
                        drums.remove(i);
                        drumsInitialQuality.remove(i);
                        i--;
                    }
                }
            }

            input = scan.nextLine();
        }
        System.out.println(drums.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
