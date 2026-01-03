package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {
    public Endereco buscarEndereco(String cep) {

        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, Endereco.class);

        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP.");
            return null;
        }
    }
}
