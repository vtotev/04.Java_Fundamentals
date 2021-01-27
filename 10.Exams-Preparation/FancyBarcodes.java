package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<String> barcodes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            barcodes.add(scan.nextLine());
        }
        for (int i = 0; i < barcodes.size(); i++) {
            String regex = "\\@\\#+[A-Z][A-Za-z0-9]*[A-Z]\\@\\#+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcodes.get(i));
            String currBarcode = barcodes.get(i).replaceAll("@#+", "");
            if(matcher.matches() && currBarcode.length() >= 6) {
                String prodGroup = "";
                for (int j = 0; j < currBarcode.length(); j++) {
                    if (Character.isDigit(currBarcode.charAt(j))) {
                        prodGroup += Character.toString(currBarcode.charAt(j));
                    }
                }
                if (prodGroup == "") prodGroup = "00";
                System.out.println("Product group: " + prodGroup);
            } else {
                System.out.println("Invalid barcode");
            }


        }
    }
}
