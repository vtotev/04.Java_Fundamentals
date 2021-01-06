package ObjectsAndClasses;

import java.util.Scanner;

public class ArticlesExc {

    static class Article {
        String Title;
        String Content;
        String Author;

        public Article(String title, String content, String author) {
            Title = title;
            Content = content;
            Author = author;
        }

        public void rename(String title) {
            Title = title;
        }

        public void edit(String content) {
            Content = content;
        }

        public void changeAuthor(String author) {
            Author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", this.Title, this.Content, this.Author);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split(",\\s+");
        int count = Integer.parseInt(scan.nextLine());
        Article myArticle = new Article(inputArr[0], inputArr[1], inputArr[2]);
        for (int i = 0; i < count; i++) {
            String[] cmd = scan.nextLine().split(": ");
            switch (cmd[0]) {
                case "Edit":
                    myArticle.edit(cmd[1]);
                    break;
                case "ChangeAuthor":
                    myArticle.changeAuthor(cmd[1]);
                    break;
                case "Rename":
                    myArticle.rename(cmd[1]);
                    break;
            }
        }
        System.out.println(myArticle.toString());
    }
}
