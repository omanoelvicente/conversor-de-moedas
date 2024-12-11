import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Log {


    public  void criaLog(List<Moeda> listaMoedas) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new SerealizaLocalDateTime())
                .setPrettyPrinting().create();

        try {
            // Ler o conteúdo existente do arquivo
            List<Object> dadosExistentes = lerLogExistente(gson);

            // Adicionar os novos dados à lista
            dadosExistentes.addAll(listaMoedas);

            // Reescrever o arquivo com a lista completa
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.json"))) {
                bufferedWriter.write(gson.toJson(dadosExistentes));
            }
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível gravar no arquivo", e);
        }
    }

    private List<Object> lerLogExistente(Gson gson) throws IOException {
        File file = new File("log.json");

        // Verificar se o arquivo existe e se não está vazio
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>(); // Retorna uma lista vazia se o arquivo não existir ou estiver vazio
        }

        // Ler o conteúdo existente do arquivo
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type listType = new TypeToken<List<Object>>() {}.getType();
            return gson.fromJson(bufferedReader, listType); // Deserializa o conteúdo em uma lista
        }
    }
}







