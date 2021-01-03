package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstNumbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondNumbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();
        for (int i = 0, z = 0; i < firstNumbers.size() && z< secondNumbers.size(); i++, z++) {
            newList.add(firstNumbers.get(i));
            newList.add(secondNumbers.get(z));
        }
        if (firstNumbers.size() > secondNumbers.size()) {
            for (int i = secondNumbers.size(); i < firstNumbers.size(); i++) {
                newList.add(firstNumbers.get(i));
            }
        } else {
            for (int i = firstNumbers.size(); i < secondNumbers.size(); i++) {
                newList.add(secondNumbers.get(i));
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i) + " ");
        }
    }
}
