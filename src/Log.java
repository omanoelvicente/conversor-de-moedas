import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {


    public <listaMoedas> void criaLog(listaMoedas listaMoedas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String data = date.format(formatter);


        try {
            FileWriter fileWriter = new FileWriter("log.json");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(gson.toJson(data));
            bufferedWriter.write(gson.toJson(listaMoedas));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel gravar no arquivo", e);
        }

    }






}
