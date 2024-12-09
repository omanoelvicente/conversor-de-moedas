import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {

    public Moeda ProcuraMoeda(String codigoMoeda1, String codigoMoeda2, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor tem que ser maior que zero");
        }
            Dotenv dotenv = Dotenv.load();
            String ExchageRateApi = dotenv.get("API_KEY");


            URI endereco = URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                    ExchageRateApi, codigoMoeda1, codigoMoeda2, valor));

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 200) {
                    throw new RuntimeException("Ocorreu um erro na API:" + response.statusCode() + "Resposta" + response.body());
                }
                if (response.body() == null) {

                    throw new NullPointerException("A resposta do servidor é nula");
                }
                return new Gson().fromJson(response.body(), Moeda.class);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Erro ao realizar requisição", e);
            }

        }
    }



