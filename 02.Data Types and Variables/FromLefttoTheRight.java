package DataTypesAndVars;

import java.util.Scanner;

public class FromLefttoTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            long iLeft = scan.nextLong();
            long iRight = scan.nextLong();
            if (iLeft > iRight) {
                iLeft = Math.abs(iLeft);
                String iLeftStr = "" + iLeft;
                int sumLeft = 0;
                for (int k = 0; k < iLeftStr.length(); k++) {
                    String a = ""+iLeftStr.charAt(k);
                    sumLeft += Integer.parseInt(a);
                }
                System.out.println(sumLeft);
            } else {
                iRight = Math.abs(iRight);
                String iRightStr = "" + iRight;
                int sumRight = 0;
                for (int j = 0; j < iRightStr.length(); j++) {
                    String a = ""+iRightStr.charAt(j);
                    sumRight += Integer.parseInt(a);
                }
                System.out.println(sumRight);
            }
        }
    }
}
