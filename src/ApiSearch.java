package src;

import com.google.gson.*;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiSearch {
    private final HttpClient client;
    private final Dotenv dotenv;

    public ApiSearch() {
        client = HttpClient.newHttpClient();
        dotenv = Dotenv.configure().load();
    }

    public double getCurrencyRatio(String c1,String c2) throws IOException,InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s".formatted(dotenv.get("API_KEY"),c1,c2)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();
        JsonElement element = JsonParser.parseString(jsonString);
        JsonObject obj = element.getAsJsonObject();
        return obj.get("conversion_rate").getAsDouble();
    }

}
