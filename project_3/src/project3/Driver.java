package project3;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Driver {
    public static void main(String[] args) {
        String filePath = args[0];
        String Api = API_Json();

        new NewsApi_Parser().fileParser(Api);
        new NewsApi_Parser().fileParser(filePath);
        new Simple_Parser().fileParser(filePath);
    }

    /**
     * Connects to the API Url and copys the Json. Uses HttpURLConnection to connect to the News API using an API key.
     * Checks that the response was vaild and using the Scanner, appends each line to a String Builder, where it
     * returns a StringBuilder to String of the News API json.
     *
     * @return String of the API Json
     */
    static String API_Json() {
        String jsonString;
        try {
            URL url = new URL("http://newsapi.org/v2/top-headlines?country=us&apiKey=b9cf3032bf254052987b482441fbd651");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            StringBuilder NewsApiJson;
            if (responseCode != 200) {
                throw new RuntimeException("Runtime Exception: " + responseCode);
            } else {
                NewsApiJson = new StringBuilder();

                Scanner NewsApiScanner = new Scanner(url.openStream());

                while (NewsApiScanner.hasNext()) {
                    NewsApiJson.append(NewsApiScanner.nextLine());
                }
                NewsApiScanner.close();
            }

            jsonString = NewsApiJson.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jsonString;
    }
}
