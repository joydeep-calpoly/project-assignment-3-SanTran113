package project3;

class SourceFormat {
    ArticleSource source;
    ArticleFormat format;
    SourceFormat (ArticleSource source, ArticleFormat format) {
        this.source = source;
        this.format = format;
    }

    Parser accept(Parser p, String json) {
        return (Parser) p.visit(json);
    }

}