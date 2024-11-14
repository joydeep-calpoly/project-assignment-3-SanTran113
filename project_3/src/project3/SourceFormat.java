package project3;

class SourceFormat {
    ArticleSource source;
    ArticleFormat format;
    SourceFormat (ArticleSource source, ArticleFormat format) {
        this.source = source;
        this.format = format;
    }

    Object accept(Parser p, String json) {
        return p.visit(json);
    }

}