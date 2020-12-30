package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> newNumbers = new ArrayList<>();
        int size = numbers.size();
        if (size % 2 == 0) {
            for (int i = 0; i < size / 2; i++) {
                newNumbers.add((numbers.get(i) + numbers.get((size - 1) - i)));
            }
        } else {
            for (int i = 0; i < size / 2; i++) {
                newNumbers.add((numbers.get(i) + numbers.get((size - 1) - i)));
            }
            newNumbers.add((numbers.get((size/2))));
        }

        for (int i = 0; i < newNumbers.size(); i++) {
            System.out.print(newNumbers.get(i)+ " ");
        }
    }
}
