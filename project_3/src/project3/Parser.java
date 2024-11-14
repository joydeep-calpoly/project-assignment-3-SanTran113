package project3;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

abstract class Parser{

    abstract void visit(String json);

//    abstract void fileParser(String json);

    /**
     * Creates a Logger object that will log any invaild articles.
     * It creates a .out file for invaild articles from any format called invaildArticles.out.
     *
     * @return a Logger object to be able to log into a .out file
     */
    Logger articleLogger() {
        Logger logger = Logger.getLogger("invalidArticles");
        FileHandler fh = null;
        try {
            fh = new FileHandler("invalidArticles.out");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        logger.addHandler(fh);

        return logger;
    }
}
