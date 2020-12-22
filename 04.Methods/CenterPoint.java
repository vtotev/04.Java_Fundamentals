package Methods;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int[] result = getClosestPoint(x1, y1, x2, y2);
        System.out.printf("(%d, %d)", result[0], result[1]);
    }

    private static int[] getClosestPoint(int x1, int y1, int x2, int y2) {
        int[] tempArr = new int[2];
        if (Math.abs(x1+y1) <= Math.abs(x2+y2)) {
            tempArr[0] = x1;
            tempArr[1] = y1;
        } else {
            tempArr[0] = x2;
            tempArr[1] = y2;
        }

        return tempArr;
    }


}
