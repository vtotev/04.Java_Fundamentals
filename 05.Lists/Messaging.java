package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scan.nextLine();
        for (int i = 0; i < numbers.size(); i++) {
            String singleNumsAsString = numbers.get(i).toString();
            List<Integer> singleNums = Arrays.stream(singleNumsAsString.split("")).map(Integer::parseInt).collect(Collectors.toList());
            int numsSum = 0;
            for (int j = 0; j < singleNums.size(); j++) {
                numsSum += singleNums.get(j);
            }
            if (numsSum >= text.length()) {
                numsSum -= text.length();
            }
            System.out.print(text.charAt(numsSum));
            text = charRemoveAt(text, numsSum);
        }
    }
    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
}
