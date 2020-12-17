package Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inp1 = scan.nextLine().split(" ");
        String[] inp2 = scan.nextLine().split(" ");

        for (int i = 0; i < inp2.length; i++) {
            for (int k = 0; k < inp1.length; k++) {
                if (inp2[i].equals(inp1[k])) {
                    System.out.print(inp2[i] + " ");
                }
            }
        }
    }
}
