package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isTrue = false;
        if (numbers.length <= 1) {
            System.out.println(0);
            return;
        }
        int pos = -5;
        for (int i = 0; i < numbers.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = i - 1; j >= 0; j--) {
                sumLeft += numbers[j];

            }

            for (int k = i + 1; k < numbers.length; k++) {
                sumRight += numbers[k];
            }

            if (sumLeft == sumRight) {
                pos = i;

                if (pos > -5) {
                    System.out.println(pos);
                    isTrue = true;
                    break;
                }
            }
        }
        if (!isTrue)
            System.out.println("no");
    }
}



/*package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length <= 1) {
            System.out.println(0);
        } else {
            int sumLeft = 0;
            int sumRight = 0;
            int pos = -5;
            for (int i = 0; i < numbers.length; i++) {

                for (int j = i - 1; j >= 0; j--) {
                    sumLeft += numbers[i];
                }

                for (int k = i + 1; k < numbers.length; k++) {
                    sumRight += numbers[k];
                }
            }
            if (sumLeft == sumRight) {
                pos = i;
            }
            if (pos > -5)
                System.out.println(pos + 1);
            else
                System.out.println("no");
        }
    }
}

/*
package Fundamentals._10_Exеrcise_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class _6_EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(a -> Integer.parseInt(a)).toArray();

        int[] arrayWithTwoZero = new int[input.length + 2];

        for (int i = 1, j = 0; i <= input.length; i++, j++) {  //добавяне на две нули, по една отпред и отзад!
            arrayWithTwoZero[i] = input[j];
        }
        arrayWithTwoZero[arrayWithTwoZero.length - 1] = 0;
        arrayWithTwoZero[0] = 0;

        int sumLeft = 0;
        int sumRight = 0;
        int index = -1;


        for (int i = 0; i < arrayWithTwoZero.length - 2; i++) {
            sumLeft += arrayWithTwoZero[i];
            sumRight = 0;
            for (int j = arrayWithTwoZero.length - 1; (j > 0 && (i + 1) < j); j--) {

                sumRight += arrayWithTwoZero[j];

                if (sumLeft == sumRight && j - i == 2) {
                    index = i;
                }
            }
        }
        if (index > -1) {
            System.out.println(index);
        } else if (index == -1) {
            System.out.println("no");
        }
    }
}
 */