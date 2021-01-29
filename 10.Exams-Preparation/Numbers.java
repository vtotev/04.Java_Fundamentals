package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        if (numbers.size() <= 1) {
            System.out.println("No");
            return;
        }
        double avg = 0;
        for (int i = 0; i < numbers.size(); i++) {
            avg += numbers.get(i);
        }
        avg /= numbers.size();
        List<Integer> greaterNums = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > avg) {
                greaterNums.add(numbers.get(i));
            }
        }
        if (greaterNums.isEmpty()) {
            System.out.println("No");
            return;
        }
        Collections.sort(greaterNums);
        Collections.reverse(greaterNums);
        for (int i = 0; i < 5; i++) {
            if (i < greaterNums.size()) {
                System.out.print(greaterNums.get(i) + " ");
            }
        }
    }
}
