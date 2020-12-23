package Methods;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        char operand = scan.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scan.nextLine());
        System.out.println(calculate(firstNum, operand, secondNum));
    }

    private static int calculate(int firstNum, char operand, int secondNum) {
        int result = 0;
        switch (operand) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                result = firstNum / secondNum;
                break;
        }
        return result;
    }
}
