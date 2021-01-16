package MapsLambdaStreamAPI;

import java.nio.file.LinkPermission;
import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String wordLowCase = input[i].toLowerCase();
            if (!wordsCount.containsKey(wordLowCase)) {
                wordsCount.put(wordLowCase, 0);
            }
            wordsCount.put(wordLowCase, wordsCount.get(wordLowCase)+1);
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWords));
    }
}
