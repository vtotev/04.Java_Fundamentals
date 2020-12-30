package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bomb = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int bombNumber = bomb.get(0);
        int bombPower = bomb.get(1);

        while (numbers.contains(bombNumber)) {
            //remove left nums
            for (int i = 1; i <= bombPower; i++) {
                int bombIndex = numbers.indexOf(bombNumber);
                if (bombIndex > 0) {
                    numbers.remove(bombIndex - 1);
                }
            }
            //remove right nums
            for (int i = 1; i <= bombPower; i++) {
                int bombIndex = numbers.indexOf(bombNumber);
                if (bombIndex < numbers.size()-1) {
                    numbers.remove(bombIndex+1);
                }
            }
            //clear bomb
            numbers.remove(numbers.indexOf(bombNumber));
        }
        //sum numbers
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}