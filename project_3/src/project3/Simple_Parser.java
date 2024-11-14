package project3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Simple_Parser extends Parser{

    @Override
    void visit(String json) {
        fileParser(json);
    }

    /**
     * Parses through a Json file from the Simple format and prints details to the client.
     * It uses two private methods, one that logs invaild articles and
     * another that prints the title, description, url, and publication date to the client.
     *
     * @param input a string with the location of the Json file
     * @return a Simple object which contains the Json object
     *
     */
    Simple fileParser(String input) {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(input);
        System.out.println(input.getClass());
        Simple info = null;

        try {
            info = mapper.readValue(file, Simple.class);

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
     * The simple format only contains, the required details from an article, title, description, url, and
     * publication date. If any article does not contain any of the required details then the article is logged as
     * invalid in an invalidArticles.out file.
     *
     * @param simpleJson Takes in any generic class
     */
    private void printDetails(Simple simpleJson) {
        Logger logger = articleLogger();

            if (simpleJson.getTitle() == null || simpleJson.getDescription() == null || simpleJson.getPublishedAt() == null || simpleJson.getUrl() ==null) {
                logger.info("Invalid Article");
            }
            System.out.println("\nTitle: " + simpleJson.getTitle());
            System.out.println("Description: " + simpleJson.getDescription());
            System.out.println("URL: " + simpleJson.getUrl());
            System.out.println("Publication: " + simpleJson.getPublishedAt());
        }

    }


