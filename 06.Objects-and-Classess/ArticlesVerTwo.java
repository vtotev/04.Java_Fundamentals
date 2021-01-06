package ObjectsAndClasses;

import java.util.*;


public class ArticlesVerTwo {

    static class Article {
        String Title;
        String Content;
        String Author;

        public Article(String title, String content, String author) {
            Title = title;
            Content = content;
            Author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", this.Title, this.Content, this.Author);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] inputArr = scan.nextLine().split(",\\s+");
            Article myArticle = new Article(inputArr[0], inputArr[1], inputArr[2]);
            articleList.add(myArticle);
        }
        String input = scan.nextLine();
        switch (input) {
            case "title":
                Collections.sort(articleList, new Comparator<Article>() {
                    @Override
                    public int compare(Article o1, Article o2) {
                        return o1.Title.compareTo(o2.Title);
                    }
                });
                break;

            case "content":
                Collections.sort(articleList, new Comparator<Article>() {
                    @Override
                    public int compare(Article o1, Article o2) {
                        return o1.Content.compareTo(o2.Content);
                    }
                });
                break;

            case "author":
                Collections.sort(articleList, new Comparator<Article>() {
                    @Override
                    public int compare(Article o1, Article o2) {
                        return o1.Author.compareTo(o2.Author);
                    }
                });
                break;
        }
        for (int i = 0; i < articleList.size(); i++) {
            System.out.println(articleList.get(i).toString());
        }
    }
}
