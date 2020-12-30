package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputData = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("3:1")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    mergeData(startIndex, endIndex, inputData);
                    break;
                case "divide":
                    int divIndex = Integer.parseInt(commands[1]);
                    int divPartitions = Integer.parseInt(commands[2]);
                    divideData(inputData, divIndex, divPartitions);
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < inputData.size(); i++) {
            System.out.print(inputData.get(i) + " ");
        }
    }

    /*    private static void divideData(int divIndex, int divPartitions, List<String> inputData) {
     //        if (divIndex < 0 || divIndex >= inputData.size()) return;
            String value = inputData.get(divIndex);
            int totalLength = value.length();

    //        if (divPartitions <= 0 || (divPartitions >= totalLength)) return;

            int sectionLength = totalLength / divPartitions;
    //        int sectionRemains = totalLength % divPartitions;
            List<String> values = Arrays.stream(inputData.get(divIndex).split("")).collect(Collectors.toList());
            int section = 1;
            while (!values.isEmpty()) {
                String tmpVal = "";
    //            System.out.println("Secton " + section + values.toString().replaceAll("[\\[\\],]", ""));
                if (values.size() > 1) {
                    for (int i = 0; i < sectionLength; i++) {
                        tmpVal += values.get(0);
                        values.remove(0);
                    }
                    inputData.add(divIndex+section, tmpVal);
                    section++;
                } else {//if (values.size() <= 1) {
                    int idx = divIndex+section-1;
                    inputData.set(idx, inputData.get(idx) + values.get(0));
                    values.remove(0);
                    section++;
                }
            }
            inputData.remove(divIndex);
        }
    */
    private static void divideData(List<String> input, int firstIndex, int secondIndex) {
        String toDivide = input.get(firstIndex);
        int length = toDivide.length() / secondIndex;
        if (secondIndex <= toDivide.length()) {
            input.remove(firstIndex);
            String[] parts = new String[secondIndex];
            int i = 0;
            while (i < secondIndex - 1) {
                parts[i] = toDivide.substring(i * length, (i + 1) * length);
                input.add(firstIndex + i, parts[i]);
                i++;
            }
            parts[i] = toDivide.substring(i * length, toDivide.length());
            input.add(firstIndex + i, parts[i]);
        }
    }

    private static void mergeData(int startIndex, int endIndex, List<String> data) {

        if (startIndex >= endIndex || startIndex >= data.size()) return;

        String newData = "";
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > data.size() - 1) {
            endIndex = data.size() - 1;

        }
        for (int i = startIndex; i <= endIndex; i++) {
            newData += data.get(i);
        }
        data.set(startIndex, newData);
        for (int i = endIndex; i > startIndex; i--) {
            data.remove(i);
        }
    }
}
