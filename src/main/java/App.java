import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

    public static void main(String[] args) {
        getRandomSwanson();
    }

    public static String getRandomQuote() {
        try {
            //Create a new Gson object
            Gson gson = new Gson();

            //Read the quotes.json file
            BufferedReader reader = new BufferedReader(new FileReader("resources/quotes.json"));

            //convert the json to  Java object (quotes)
            Quote[] quotes = gson.fromJson(reader, Quote[].class);

            //Generating a random number based on array length
            int rand = (int) (Math.random() * (quotes.length));

            //Printing out random quote
            return quotes[rand].toString();
        } catch (IOException e) {
            return null;
        }
    }

    public static Quote getRandomSwanson() {
        try {
            //Make URL connection
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            //Read in stream
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder json = new StringBuilder();
            String inputLine;

            // StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {

                // content.append(inputLine);
                System.out.println(inputLine.substring(1, inputLine.length() - 1));
            }
            in.close();

//             TODO: new code to parse swanson quote CODE IN PROGRESS. Throws NullPointerException >.<
//            Gson gson = new Gson();
//            String[] parsedJson = gson.fromJson(json.toString(), String[].class);
//            Quote answer = new Quote(parsedJson[0]);
//            System.out.println(answer);
//            return answer;


        } catch (IOException e) {
            System.out.print(e);
            System.out.println("\n\nYou have lost internet connectivity. The Purge will begin shortly...\n");
            System.out.println(getRandomQuote());
        }
        return null;
    }
}
