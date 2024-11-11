package project3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


class NewsApi_Article {
    private final Source source;
    private final String author;
    private final String title;
    private final String description;
    private final String url;
    private final String urlToImage;
    private final String publishedAt;
    private final String content;

    @JsonIgnoreProperties
    @JsonCreator
    NewsApi_Article(@JsonProperty("source") Source source, @JsonProperty("author") String author, @JsonProperty("title") String title,
                    @JsonProperty("description") String description, @JsonProperty("url") String url, @JsonProperty("urlToImage") String urlToImage,
                    @JsonProperty("publishedAt") String publishedAt, @JsonProperty("content") String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }


    private static class Source {
        private final String id;
        private final String name;

        @JsonIgnoreProperties
        @JsonCreator
        private Source (@JsonProperty("id") String id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }

    }

    String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    String getContent() {
        return content;
    }


    String getSourceId() {
        return source.id;
    }

    String getSourceName() {
        return source.name;
    }

}