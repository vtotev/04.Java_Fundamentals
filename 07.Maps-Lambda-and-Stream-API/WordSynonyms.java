package MapsLambdaStreamAPI;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> wordsList = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            wordsList.putIfAbsent(word, new ArrayList<>());
            wordsList.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordsList.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
