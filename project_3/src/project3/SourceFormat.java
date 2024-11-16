package project3;

class SourceFormat {
    ArticleSource source;
    ArticleFormat format;
    SourceFormat (ArticleSource source, ArticleFormat format) {
        this.source = source;
        this.format = format;
    }

    /**
     * Navigates to the visit method of the given Parser
     * @param p Any parser that extends the Parser abstract class
     * @param json A string in json format
     */
    void accept(Parser p, String json) {
        p.visit(json);
    }

}