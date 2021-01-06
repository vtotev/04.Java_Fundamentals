package ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb = Integer.parseInt(scan.nextLine());
        BigInteger sum = new BigInteger("1");
        for (int i = 1; i <= numb; i++) {
            BigInteger indx = new BigInteger(""+i);
            sum = sum.multiply(indx);
        }
        System.out.println(sum);
    }
}
