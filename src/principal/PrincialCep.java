package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincialCep {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner cep = new Scanner(System.in);
        System.out.println("Digite o cep do destino.");
        var buscar = cep.nextLine();

        String endereco = "https://viacep.com.br/ws/" + buscar + "/json/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder().create();
        Endereco meuEndereco = gson.fromJson(json, Endereco.class);

        System.out.println("Endereço convertido.");
        System.out.println(meuEndereco);


    }
}
