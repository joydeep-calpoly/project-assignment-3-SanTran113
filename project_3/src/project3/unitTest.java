package project3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unitTest {
    /**
     * Given an empty file, both NewsApi Parser and Simple Parser will return a null
     */
    @Test
    void testEmptyFile() {
        assertNull(new NewsApi_Parser().fileParser("inputs/empty.json"));
        assertNull(new Simple_Parser().fileParser("inputs/empty.json"));
    }

    /**
     * Given a file that does not exist, both NewsApi Parser and Simple Parser will return null
     */
    @Test
    void testFileDoesNotExist() {
        assertNull(new NewsApi_Parser().fileParser("inputs/doesNotExist.json"));
        assertNull(new Simple_Parser().fileParser("inputs/doesNotExist.json"));
    }

    /**
     * Given a file that has the wrong Json Format, both NewsApi Parser and Simple Parser will return null
     */
    @Test
    void testWrongFormat() {
        assertNull(new NewsApi_Parser().fileParser("inputs/wrongFormat.json"));
        assertNull(new Simple_Parser().fileParser("inputs/wrongFormat.json"));
    }

    /**
     * Tests that main is able to connect to the both NewsApi Parser and Simple Parser using a json file
     */
    @Test
    void testParseMainVaildFile() {
        assertDoesNotThrow(() -> Driver.main(new String[]{"inputs/example.json"}));
        assertDoesNotThrow(() -> Driver.main(new String[]{"inputs/simple.json"}));
    }

    /**
     * Given bad.json in NewsApi Format, this test checks that each article was parsed through by using size()
     */
    @Test
    void testCountPrintArticlesBad() {
        NewsApi_Parser p = new NewsApi_Parser();
        NewsApiInfo a = p.fileParser("inputs/bad.json");
        assertEquals(21, a.getArticles().size());
    }

    /**
     * Given example.json in NewsApi Format, this test checks that each article was parsed through by using size()
     */
    @Test
    void testCountVaildArticlesExample() {
        NewsApi_Parser p = new NewsApi_Parser();
        NewsApiInfo a = p.fileParser("inputs/example.json");
        assertEquals(20, a.getArticles().size());
    }

    /**
     * testVaildNullMissing tests the limits of null within a NewsApi Formatted Json.
     * Given testVaildNull.json, the test will check what each variable contains from each article.
     * testVaildNull.json contains two articles. testVaildNullMissing will test the first article that contains only
     * the required information, title, description, url, and publishedAt where every other instance variable is
     * missing from the json.
     */
    @Test
    void testNewsApiVaildNullMissing() {
        NewsApi_Parser p = new NewsApi_Parser();
        NewsApiInfo a = p.fileParser("inputs/testVaildNull.json");
        assertNull(a.getArticles().get(0).getSourceId());
        assertNull(a.getArticles().get(0).getSourceName());
        assertNull(a.getArticles().get(0).getAuthor());
        assertEquals("NASA helicopter took a piece of the Wright brothers' plane to Mars - CNET", a.getArticles().get(0).getTitle());
        assertEquals("NASA is gearing up for a dramatic Mars test flight of Ingenuity as soon as April 8.", a.getArticles().get(0).getDescription());
        assertEquals("https://www.cnet.com/news/nasa-helicopter-took-a-piece-of-the-wright-brothers-famous-plane-to-mars/", a.getArticles().get(0).getUrl());
        assertNull(a.getArticles().get(0).getUrlToImage());
        assertEquals("2021-03-24T21:43:00Z", a.getArticles().get(0).getPublishedAt());
        assertNull(a.getArticles().get(0).getContent());
    }

    /**
     * testVaildNullSet tests the limits of null within a NewsApi Formatted Json.
     * Given testVaildNull.json, the test will check what each variable contains from each article.
     * testVaildNull.json contains two articles. testVaildNullSet will test the second article which contains the
     * required information, title, description, url, and publishedAt where every other instance variable initialized
     * as null.
     */
    @Test
    void testNewsApiVaildNullSet() {
        NewsApi_Parser p = new NewsApi_Parser();
        NewsApiInfo a = p.fileParser("inputs/testVaildNull.json");
        assertEquals(2, a.getArticles().size());
        assertNull(a.getStatus());
        assertNull(a.getTotalResults());
        assertNull(a.getArticles().get(1).getSourceId());
        assertNull(a.getArticles().get(1).getSourceName());
        assertNull(a.getArticles().get(1).getAuthor());
        assertEquals("People line the streets of Boulder to honor slain police Officer Eric Talley - CNN", a.getArticles().get(1).getTitle());
        assertEquals("Boulder, Colorado, continued to mourn fallen Officer Eric Talley on Wednesday.", a.getArticles().get(1).getDescription());
        assertEquals("https://www.cnn.com/2021/03/24/us/officer-talley-procession/index.html", a.getArticles().get(1).getUrl());
        assertNull(a.getArticles().get(1).getUrlToImage());
        assertEquals("2021-03-24T22:20:12Z", a.getArticles().get(1).getPublishedAt());
        assertNull(a.getArticles().get(1).getContent());
    }

    /**
     * Given simple.json, checks that each instance variable is populated with the correct information
     */
    @Test
    void testSimpleFormat() {
        Simple_Parser p = new Simple_Parser();
        Simple s = p.fileParser("inputs/simple.json");
        assertEquals("Extend Assignment #1 to support multiple sources and to introduce source processor.", s.getDescription());
        assertEquals("2021-04-16 09:53:23.709229", s.getPublishedAt());
        assertEquals("Assignment #2", s.getTitle());
        assertEquals("https://canvas.calpoly.edu/courses/55411/assignments/274503", s.getUrl());
    }

    /**
     * Given Simple json Format file where every instance variable is declared as null, the test will assert each
     * instance as null and log the article.
     */
    @Test
    void testAllNullSimpleFormat() {
        Simple_Parser p = new Simple_Parser();
        Simple s = p.fileParser("inputs/simpleAllNull.json");
        assertNull(s.getDescription());
        assertNull(s.getPublishedAt());
        assertNull(s.getTitle());
        assertNull(s.getUrl());
    }

    /**
     * Given Simple json Format file where one instance variable is missing, the test will log the article.
     */
    @Test
    void testNullSimpleMissingVar() {
        Simple_Parser p = new Simple_Parser();
        Simple s = p.fileParser("inputs/simpleMissingVar.json");
        assertEquals("Extend Assignment #1 to support multiple sources and to introduce source processor.", s.getDescription());
        assertEquals("2021-04-16 09:53:23.709229", s.getPublishedAt());
        assertEquals("Assignment #2", s.getTitle());
        assertNull(s.getUrl());
    }

    @Test
    void testVisitSimple() {
        Simple_Parser simple = new Simple_Parser();
        String filePath = "inputs/simple.json";
        SourceFormat article = new SourceFormat(ArticleSource.FILE, ArticleFormat.SIMPLE);
        assertNotNull(article.accept(simple, filePath));
    }

    @Test
    void testVisitNewsApiFile() {
        NewsApi_Parser newsApi = new NewsApi_Parser();
        String filePath = "inputs/newsapi.json";
        SourceFormat article = new SourceFormat(ArticleSource.FILE, ArticleFormat.NEWSAPI);
        assertNotNull(article.accept(newsApi, filePath));
    }

    @Test
    void testVisitNewsApiAPI() {
        NewsApi_Parser newsApi = new NewsApi_Parser();
        SourceFormat article = new SourceFormat(ArticleSource.FILE, ArticleFormat.NEWSAPI);
        assertNotNull(article.accept(newsApi, "filePath"));
    }
}