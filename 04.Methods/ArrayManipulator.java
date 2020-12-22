package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.toLowerCase().equals("end")) {
            String[] cmd = input.split(" ");
            switch (cmd[0].toLowerCase()) {
                case "exchange":
                    int exIndex = Integer.parseInt(cmd[1]) + 1;
                    exchangeArray(numbers, exIndex);
                    break;
                case "max":
                case "min":
                    int minmax = minMaxEvenOdd(cmd[0], cmd[1], numbers);
                    if (minmax > -1) {
                        System.out.println(minmax);
                    } else System.out.println("No matches");
                    break;
                case "first":
                case "last":
                    String firstLast = firstLastEvenOdd(cmd[0], cmd[2], numbers, Integer.parseInt(cmd[1]));
                    System.out.println(firstLast);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(Arrays.toString(numbers));
    }


    private static String firstLastEvenOdd(String firstLast, String evenOdd, int[] numbers, int count) {
        int[] evenOddNum = new int[count];
        int evenOddCount = 0;
        if (count > 0 && count <= numbers.length) {
            switch (firstLast.toLowerCase()) {
                case "first":
                    switch (evenOdd.toLowerCase()) {
                        case "even":
                            for (int i = 0; i < numbers.length; i++) {
                                if (numbers[i] % 2 == 0 && evenOddCount < count) {
                                    evenOddNum[evenOddCount] = numbers[i];
                                    evenOddCount++;
                                }
                            }
                            break;
                        case "odd":
                            for (int i = 0; i < numbers.length; i++) {
                                if (numbers[i] % 2 != 0 && evenOddCount < count) {
                                    evenOddNum[evenOddCount] = numbers[i];
                                    evenOddCount++;
                                }
                            }
                            break;
                    }
                    int[] firstArr = new int[evenOddCount];
                    for (int i = 0; i < evenOddCount; i++) {
                        firstArr[i] = evenOddNum[i];
                    }
                    evenOdd = Arrays.toString(firstArr);
                    break;

                case "last":
                    switch (evenOdd.toLowerCase()) {
                        case "even":
                            for (int i = numbers.length-1; i >= 0; i--) {
                                if (numbers[i] % 2 == 0 && evenOddCount < count) {
                                    evenOddNum[evenOddCount] = numbers[i];
                                    evenOddCount++;
                                }
                            }
                            break;
                        case "odd":
                            for (int i = numbers.length-1; i >= 0; i--) {
                                if (numbers[i] % 2 != 0 && evenOddCount < count) {
                                    evenOddNum[evenOddCount] = numbers[i];
                                    evenOddCount++;
                                }
                            }
                            break;
                    }
                    int[] lastArr = new int[evenOddCount];
                    for (int i = 0, y = lastArr.length-1; i < lastArr.length && y >= 0; i++, y--) {
                        lastArr[i] = evenOddNum[y];
                    }
                    int[] tempArr = new int[count];
                    if ((lastArr.length-1) > count) {
                        for (int i = 0, y = lastArr.length-count; i < count && y < lastArr.length; i++, y++) {
                            tempArr[i] = lastArr[y];
                        }
                        evenOdd = Arrays.toString(tempArr);
                    } else {
                        evenOdd = Arrays.toString(lastArr);
                    }
                    break;
            }
        } else evenOdd = "Invalid count";
        return evenOdd;
    }

    private static int minMaxEvenOdd(String minMax, String evenOdd, int[] numbers) {
        int evenOddNum;
        int evenOddidx = -1;
        switch (minMax.toLowerCase()) {
            case "max":
                evenOddNum = Integer.MIN_VALUE;
                switch (evenOdd.toLowerCase()) {
                    case "even":
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] % 2 == 0 && numbers[i] > evenOddNum) {
                                evenOddNum = numbers[i];
                                evenOddidx = i;
                            }
                        }
                        break;
                    case "odd":
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] % 2 != 0 && numbers[i] > evenOddNum) {
                                evenOddNum = numbers[i];
                                evenOddidx = i;
                            }
                        }
                        break;
                }
                break;

            case "min":
                evenOddNum = Integer.MAX_VALUE;
                switch (evenOdd.toLowerCase()) {
                    case "even":
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] % 2 == 0 && numbers[i] <= evenOddNum) {
                                evenOddNum = numbers[i];
                                evenOddidx = i;
                            }
                        }
                        break;
                    case "odd":
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] % 2 != 0 && numbers[i] <= evenOddNum) {
                                evenOddNum = numbers[i];
                                evenOddidx = i;
                            }
                        }
                        break;
                }
                break;
        }
        return evenOddidx;
    }


    public static void exchangeArray(int[] numbers, int count) {
        if (count <= 0 || count > numbers.length) {
            System.out.println("Invalid index");
            return;
        }
        if (count == numbers.length)
            return;

        int[] arr1 = new int[count];
        int[] arr2 = new int[numbers.length-count];

        for (int i = 0; i < count; i++) {
            arr1[i] = numbers[i];
        }
        for (int i = 0, z = count; i < arr2.length && z < numbers.length; i++, z++) {
            arr2[i] = numbers[z];
        }

        for (int i = 0; i < arr2.length; i++) {
            numbers[i] = arr2[i];
        }
        for (int i = arr2.length, z = 0; i < numbers.length && z < arr1.length; i++, z++) {
            numbers[i] = arr1[z];
        }

    }

}
