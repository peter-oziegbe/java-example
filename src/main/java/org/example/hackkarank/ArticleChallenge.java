package org.example.hackkarank;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ArticleChallenge {

    public static void main(String[] args) {
        int limit = 10; // Change this to your desired limit
        List<Article> articles = fetchArticles(limit);
        articles.forEach(article -> System.out.println(article.title));
    }

    public static List<Article> fetchArticles(int limit) {
        List<Article> articles = new ArrayList<>();

        try {
            int pageNumber = 1;
            int totalPages = Integer.MAX_VALUE;
            while (articles.size() < limit && pageNumber <= totalPages) {
                String apiUrl = "https://jsonmock.hackerrank.com/api/articles?page=" + pageNumber;
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                    Map<String, Object> response = new Gson().fromJson(inputStreamReader, Map.class);
                    totalPages = ((Double) response.get("total_pages")).intValue();
                    List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");

                    for (Map<String, Object> articleData : data) {
                        if( articleData.get("title") != null && articleData.get("num_comments") != null){
                            String title = (String) articleData.get("title");
                            double commentCount = (Double)articleData.get("num_comments");
                            articles.add(new Article(title, commentCount));
                        }

                    }
                }

                pageNumber++;
            }

            // Sort articles by comment count decreasing, then alphabetically decreasing
            articles.sort((a1, a2) -> {
                if (a1.comment_count != a2.comment_count) {
                    return Double.compare(a2.comment_count, a1.comment_count); // decreasing by comment count
                } else {
                    return a2.title.compareTo(a1.title); // decreasing alphabetically
                }
            });

            // Truncate the list to the specified limit
            if (articles.size() > limit) {
                articles = articles.subList(0, limit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
class Article {
    String title;
    double comment_count;

    public Article(String title, double comment_count) {
        this.title = title;
        this.comment_count = comment_count;
    }
}
