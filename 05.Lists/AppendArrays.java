package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> arrayList = new ArrayList<>(Arrays.asList(input.split("\\|")));
        List<String> output = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            List<String> items = new ArrayList<>(Arrays.asList(arrayList.get(i).split("\\s+")));
            String midOutput = "";
            while (true) {
                if (!items.remove("") || !items.remove("\\s+"))
                    break;
            }
            for (int j = 0; j < items.size(); j++) {
                midOutput += items.get(j) + " ";
            }
            output.add(midOutput);
        }
        for (int i = output.size()-1; i >= 0; i--) {
            System.out.print(output.get(i));
        }
    }
}
