package project3;

class SourceFormat {
    ArticleSource source;
    ArticleFormat format;
    SourceFormat (ArticleSource source, ArticleFormat format) {
        this.source = source;
        this.format = format;
    }

    void accept(Parser p, String json) {
        p.visit(json);
    }

}