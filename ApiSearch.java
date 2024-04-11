import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ApiSearch {
    private final HttpClient client;

    public ApiSearch() {
        client = HttpClient.newHttpClient();
    }

    public double getCurrencyRatio(String c1,String c2){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GPB"))
                .build();
        return 2;
    }
}
