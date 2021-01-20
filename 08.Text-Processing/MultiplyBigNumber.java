package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstNum = scan.nextLine();
        int secNum = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstNum.length(); i++) {
            if (firstNum.charAt(i) != '0') {
                firstNum = firstNum.substring(i);
                break;
            }
        }
        if (secNum == 0) {
            System.out.println("0");
            return;
        }
        int remains = 0;
        char[] numbers = firstNum.toCharArray();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int currNum = ((numbers[i] - '0') * secNum) + remains;
            remains = currNum / 10;
            currNum %= 10;
            sb.append(currNum);
        }
        if (remains > 0) {
            sb.append(remains);
        }
        sb.reverse();
        System.out.println(sb);
    }
}
