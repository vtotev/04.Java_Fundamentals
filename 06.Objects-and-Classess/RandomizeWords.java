package ObjectsAndClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Random rnd = new Random();
        for (int i = 0; i < words.size(); i++) {
            String oldValue = words.get(i);
            int newIndex = rnd.nextInt(words.size());
            String newValue = words.get(newIndex);
            words.set(i, newValue);
            words.set(newIndex, oldValue);
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}
