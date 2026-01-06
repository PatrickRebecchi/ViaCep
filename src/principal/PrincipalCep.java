package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;
import service.ViaCepService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCep {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ViaCepService service = new ViaCepService();

        List<Endereco> enderecos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while(true) {


            System.out.println("Digite o CEP ( ou 'sair' para encerrar) ");
            String busca = scanner.nextLine().replace("-", "");

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            Endereco endereco = service.buscarEndereco(busca);

            if (endereco == null || endereco.isErro()) {
                System.out.println("CEP inválido ou não encontrado.");
            } else {
                enderecos.add(endereco);
                System.out.println(endereco);
            }

        }


        try (FileWriter escrita = new FileWriter("enderecos.json")) {
            escrita.write(gson.toJson(enderecos));
        }

        System.out.println("\nEndereços buscados:");
        System.out.println(enderecos);
        System.out.println("Programa finalizado.");

        scanner.close();
    }
}
