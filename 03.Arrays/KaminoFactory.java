package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int sumBigger = 0;
        int sumIndex = 0;
        int startIndex = length;
        int[] sums = new int[length];
        while (!input.equals("Clone them!")) {
            int[] nums = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sumBigger < sum) {
                sumBigger = sum;
                sumIndex++;
                sums = nums;
            }
            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", sumIndex, sumBigger);
        for (int i = 0; i < sums.length; i++) {
            System.out.print(sums[i] + " ");
        }
//        System.out.println();
    }
}



/*

        Scanner scan = new Scanner(System.in);

        int sizeField = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();
        String forAllZeros = input;

        int numberDNAtest = 0;
        int localNumber = 0;
        int bestSum = 0;
        int bestLength = 0;
        int bestNumber = 0;
        int bestIndex = 0;
        String bestSequence = "";
        String bestInput = "";
        boolean zeros = false;

        String localnput = "";
        while (!input.equals("Clone them!")) {

            String noChars = input.replaceAll("!+", "");
            String[] noZeros = noChars.split("0");
            numberDNAtest++;
            int localLength = 0;
            String localSequence = "";
            int sum = 0;


            for (int j = 0; j < noZeros.length; j++) {
                if (noZeros[j].length() > localLength) {
                    localLength = noZeros[j].length();
                    localNumber = numberDNAtest;
                    localSequence = noZeros[j];
                    localnput = noChars;

                }
                sum += noZeros[j].length();
                if (sum > 0) {
                    zeros = true;
                }
            }
            int localIndex = noChars.indexOf(localSequence);

            if (localLength > bestLength) {
                bestLength = localLength;
                bestNumber = numberDNAtest;
                bestInput = localnput;
                bestSum = sum;
                bestIndex = localIndex;


            } else if (localLength == bestLength) {
                if (localIndex < bestIndex) {
                    bestLength = localLength;
                    bestNumber = numberDNAtest;
                    bestInput = localnput;
                    bestSum = sum;
                    bestIndex = localIndex;
                } else if (localIndex == bestIndex) {
                    if (bestSum < sum) {
                        bestLength = localLength;
                        bestNumber = numberDNAtest;
                        bestInput = localnput;
                        bestSum = sum;
                        bestIndex = localIndex;
                    }
                } else {
                    continue;
                }
            }

            localLength = 0;
            localNumber = 0;
            localSequence = "";
            localnput = "";
            sum = 0;


            input = scan.nextLine();


        }
        if (zeros == false) {
            String output1 = forAllZeros.replaceAll("!+","");  //Проверка когато входа е 0!0!0!0!0
            String [] bestAllZero = output1.split("");

            System.out.println("Best DNA sample 1" + " with sum: " + 0 + ".");
            for (int i = 0; i < bestAllZero.length; i++) {
                System.out.print(bestAllZero[i] + " ");
            }

        } else {
            String[] output = bestInput.split("");

            System.out.println("Best DNA sample " + (bestNumber) + " with sum: " + bestSum + ".");
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
        }

    }
}

*/