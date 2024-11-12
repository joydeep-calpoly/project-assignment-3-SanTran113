package project3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Simple extends SourceFormat{
    private final String description;
    private final String publishedAt;
    private final String url;
    private final String title;

    @JsonCreator
    Simple (@JsonProperty("description") String description, @JsonProperty("publishedAt") String publishedAt,
            @JsonProperty("url") String url, @JsonProperty("title") String title) {
        this.description = description;
        this.publishedAt = publishedAt;
        this.url = url;
        this.title = title;
    }

    @Override
    void accept(Parser parser) {
        parser.visit(this);
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

    public String getPublishedAt() {
        return publishedAt;
    }
}
