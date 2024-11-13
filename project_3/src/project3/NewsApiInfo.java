package project3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class NewsApiInfo{
    private final String status;
    private final Integer totalResults;
    private final List<NewsApi_Article> articles;

    @JsonCreator
    NewsApiInfo(@JsonProperty("status") String status, @JsonProperty("totalResults") Integer totalResults,
                @JsonProperty("articles") List<NewsApi_Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    String getStatus() {
        return status;
    }

    Integer getTotalResults() {
        return totalResults;
    }

    List<NewsApi_Article> getArticles() {
        return articles;
    }
}