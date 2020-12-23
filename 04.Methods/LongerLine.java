package Methods;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] points = new int[8];
        // x1, y1;   x2, y2;   x3, y3;   x4, y4
        for (int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(scan.nextLine());
        }
        longestLine(points);
    }

    private static void longestLine(int[] points) {
        int[] firstPoint;
        int[] secondPoint;
        double firstLength = calcLength(points[0], points[1], points[2], points[3]);
        double secondLength = calcLength(points[4], points[5], points[6], points[7]);
        if (firstLength >= secondLength) {
            firstPoint = getClosestPoint(points[0], points[1], points[2], points[3]);
            secondPoint = getFurtherPoint(points[0], points[1], points[2], points[3]);
            System.out.printf("(%d, %d)(%d, %d)", firstPoint[0], firstPoint[1], secondPoint[0], secondPoint[1]);
        } else {
            firstPoint = getClosestPoint(points[4], points[5], points[6], points[7]);
            secondPoint = getFurtherPoint(points[4], points[5], points[6], points[7]);
            System.out.printf("(%d, %d)(%d, %d)", firstPoint[0], firstPoint[1], secondPoint[0], secondPoint[1]);
        }
    }

    private static int[] getClosestPoint(int x1, int y1, int x2, int y2) {
        int[] tempArr = new int[2];

        double first = Math.sqrt(Math.pow(Math.abs(x1), 2) + Math.pow(Math.abs(y1), 2));
        double second = Math.sqrt(Math.pow(Math.abs(x2), 2) + Math.pow(Math.abs(y2), 2));

        if (first <= second) {
            tempArr[0] = x1;
            tempArr[1] = y1;
        } else {
            tempArr[0] = x2;
            tempArr[1] = y2;
        }

        return tempArr;
    }

    private static int[] getFurtherPoint(int x1, int y1, int x2, int y2) {
        int[] tempArr = new int[2];
        double first = Math.sqrt(Math.pow(Math.abs(x1), 2) + Math.pow(Math.abs(y1), 2));
        double second = Math.sqrt(Math.pow(Math.abs(x2), 2) + Math.pow(Math.abs(y2), 2));

        if (first > second) {
            tempArr[0] = x1;
            tempArr[1] = y1;
        } else {
            tempArr[0] = x2;
            tempArr[1] = y2;
        }

        return tempArr;
    }

    public static double calcLength(int x1, int y1, int x2, int y2) {
        int a = Math.abs(x2 - x1);
        int b = Math.abs(y2 - y1);
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c;
    }

}
