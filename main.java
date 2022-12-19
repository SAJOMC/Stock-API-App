import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);

        out.println("Welcome to the CLI stock retriever");

        out.println("What ticker would you like info on? (Enter \"EXIT\" to stop):");
        String userInput = scanner.nextLine();


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + userInput + "&apikey=I81VR1KXCLK4EZ3S")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(out::println)
                .join();
        {


            while (!Objects.equals(userInput, "EXIT")) {
                out.println("What ticker would you like info on? (Enter \"EXIT\" to stop):");
                userInput = scanner.nextLine();
                if (Objects.equals(userInput, "EXIT")) {
                    out.println("Goodbye");
                }
            }
        }

    }
}
   /* public static String parse(String responseBody) {
        JSONArray stonks = new JSONArray(responseBody);{
            JSONObject stonk = stonks.getJSONObject('0');
            int open = stonk.getInt("1. open");
            int high = stonk.getInt("2. high");
            int Low = stonk.getInt("3. low");
            int Current = stonk.getInt("4. current");
            int Volume = stonk.getInt("5. volume");
            System.out.println(open + " " + high + " " + Low + " " + Current + " " + Volume);
        }
        return null;
  */