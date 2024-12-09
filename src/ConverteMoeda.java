import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoeda {
    Dotenv dotenv = Dotenv.load();
    String ExchageRateApi = dotenv.get("API_KEY");


    URI endereco = URI.create(String.format("https://v6.exchangerate-api.com/v6/pair/%s/%s/%.2f", ));
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(endereco)
            .build();
    HttpResponse<String> response;

    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
