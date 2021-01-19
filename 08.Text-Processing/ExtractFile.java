package TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String fileName = input.substring(input.lastIndexOf("\\")+1, input.lastIndexOf("."));
        String fileExt = input.substring(input.lastIndexOf(".")+1);
        System.out.printf("File name: %s%nFile extension: %s%n", fileName, fileExt);
    }
}
