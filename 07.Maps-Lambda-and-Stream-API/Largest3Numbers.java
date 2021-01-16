package MapsLambdaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1)).limit(3).collect(Collectors.toList());
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i)+" ");
        }
    }
}
