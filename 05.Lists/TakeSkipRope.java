package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isDigit(inputStr.charAt(i))) {
                numbers.add(Integer.parseInt(String.valueOf(inputStr.charAt(i))));
            } else nonNumbers.add(inputStr.charAt(i));
        }
        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isDigit(inputStr.charAt(i))) {
                inputStr = charRemoveAt(inputStr, i);
                i=-1;
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else
                skipList.add(numbers.get(i));

        }
        String newOutput = "";
        for (int i = 0, z = 0; i < takeList.size() && z < skipList.size(); i++, z++) {
            int takeNum = takeList.get(i);
            int skipNum = skipList.get(z);
            for (int j = 0; j < takeNum; j++) {
                if (inputStr.equals("")) break;
                newOutput += inputStr.charAt(0);
                inputStr = charRemoveAt(inputStr,0);
            }
            for (int j = 0; j < skipNum; j++) {
                if (inputStr.equals("")) break;
                inputStr = charRemoveAt(inputStr,0);
            }
        }
        System.out.println(newOutput);
     }

    public static String charRemoveAt(String str, int p)
    {
        return str.substring(0, p) + str.substring(p + 1);
    }
}
