package project3;

abstract class SourceFormat {
    ArticleSource source;
    ArticleFormat format;
    SourceFormat (ArticleSource source, ArticleFormat format) {
        this.source = source;
        this.format = format;
    }

    abstract void accept(Parser p);

    ArticleSource getSource() {
        return source;
    }

    ArticleFormat getFormat() {
        return format;
    }
}