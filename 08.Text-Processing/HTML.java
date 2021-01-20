package TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        String content = scan.nextLine();
        String comments = scan.nextLine();
        List<String> commentsList = new ArrayList<>();
        String newComment = scan.nextLine();
        while (!newComment.equals("end of comments")) {
            commentsList.add(newComment);
            newComment = scan.nextLine();
        }
        System.out.printf("<h1>%n    %s%n</h1>%n", title);
        System.out.printf("<article>%n    %s%n</article>%n", content);
        System.out.printf("<div>%n    %s%n</div>%n", comments);
        for (int i = 0; i < commentsList.size(); i++) {
            System.out.printf("<div>%n    %s%n</div>%n", commentsList.get(i));
        }
    }
}
