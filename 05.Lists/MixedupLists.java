package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class MixedupLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstNumbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondNumbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mergedList = new ArrayList<>();
        List<Integer> margins = new ArrayList<>();

        if (firstNumbers.size() > secondNumbers.size()) {
            margins.add(firstNumbers.get(firstNumbers.size() - 1));
            firstNumbers.remove(firstNumbers.size() - 1);
            margins.add(firstNumbers.get(firstNumbers.size() - 1));
            firstNumbers.remove(firstNumbers.size() - 1);
        } else {
            margins.add(secondNumbers.get(0));
            secondNumbers.remove(0);
            margins.add(secondNumbers.get(0));
            secondNumbers.remove(0);
        }
        Collections.sort(margins);

        for (int i = 0, z = secondNumbers.size() - 1; i < firstNumbers.size() && z >= 0; i++, z--) {
            mergedList.add(firstNumbers.get(i));
            mergedList.add(secondNumbers.get(z));
        }
        Collections.sort(mergedList);

        int startMargin = margins.get(0);
        int endMargin = margins.get(1);

        for (int i = 0; i < mergedList.size(); i++) {
            int num = mergedList.get(i);
            if (num > startMargin && num < endMargin) {
                System.out.print(num + " ");
            }
        }
    }
}
