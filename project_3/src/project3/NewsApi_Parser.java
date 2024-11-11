package project3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

class NewsApi_Parser extends Parser{

    @Override
    void visit(NewsApi_Parser newsApi){
        newsApi.fileParser("");
    }

    /**
     * Parses through a Json file from the News API and prints details to the client.
     * It uses two private methods, one that logs invaild articles and
     * another that prints the title, description, url, and publication date to the client.
     *
     * @param input a string with the location of the Json file
     * @return an ArticleInfo object which contains the Json object
     *
     */
    NewsApiInfo fileParser(String input) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(input);
        System.out.println(input.getClass());
        NewsApiInfo info = null;

        try {
            info = mapper.readValue(file, NewsApiInfo.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (info != null) {
            printDetails(info);
        }

        return info;

    }


    /**
     * Prints out the details of article(s) to the client.
     * The NewsApiInfo format prints out the required details from an article, title, description, url, and
     * publication date, as well as the status, and total results. If any article does not contain any of the required
     * details then the article is logged as invalid in an invalidArticles.out file.
     *
     * @param articleInfo Takes in any generic class
     */
    private void printDetails(NewsApiInfo articleInfo) {
        System.out.println("Status: " + articleInfo.getStatus());
        System.out.println("Total Results: " + articleInfo.getTotalResults());
        System.out.println("\nArticles: ");
        Logger logger = articleLogger();

        for (NewsApi_Article article : articleInfo.getArticles()) {
            if (article.getTitle() == null || article.getDescription() == null || article.getPublishedAt() == null || article.getUrl() ==null) {
                logger.info("Invalid Article");
                continue;
            }
            System.out.println("\nTitle: " + article.getTitle());
            System.out.println("Description: " + article.getDescription());
            System.out.println("URL: " + article.getUrl());
            System.out.println("Publication: " + article.getPublishedAt());
        }

    }

}

