package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);      // деклариране на вход
        long inputA = factorial(Integer.parseInt(scan.nextLine()));  // въвеждане на първо число и пресмятането на факториела му
        long inputB = factorial(Integer.parseInt(scan.nextLine()));  // въвеждане на второ число и пресмятането на факториела му
        double divResult = (double) inputA / inputB;                // делим факториела на двете числа
        System.out.printf("%.2f", divResult);               // печатаме резултата от деленето
    }

    private static long factorial(int inputNumber) {        // функция за пресмятане на факториел
        long fact = 1;                                  //започваме от числото 1
        for (int i = 1; i <= inputNumber; i++) {        // цикъл за умножение на числта от 1 до N (т.е. до първо или второ число
            fact *= i;
        }
        return fact;        // връщаме резултат
    }
}
