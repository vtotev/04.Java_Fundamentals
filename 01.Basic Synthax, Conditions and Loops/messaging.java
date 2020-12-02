package BasicExercise;

import java.util.Scanner;

public class messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String outp = "";
        for (int i = 1; i <= count; i++) {
            String input = scan.nextLine();
            int index = -1;
            switch (input.charAt(0)) {
                case '2':
                    index = 0 + input.length() - 1;
                    break;

                case '3':
                    index = 3 + input.length() - 1;
                    break;

                case '4':
                    index = 6 + input.length() - 1;
                    break;

                case '5':
                    index = 9 + input.length() - 1;
                    break;

                case '6':
                    index = 12 + input.length() - 1;
                    break;

                case '7':
                    index = 15 + input.length() - 1;
                    break;

                case '8':
                    index = 19 + input.length() - 1;
                    break;

                case '9':
                    index = 22 + input.length() - 1;
                    break;

                case '0':
                    outp = outp + " ";
                    index = -1;
                    break;
            }
            if (index != -1) {
                index += 97;
                char symb = (char) index;
                outp += symb;
            }
        }
                System.out.println(outp);
    }
}
