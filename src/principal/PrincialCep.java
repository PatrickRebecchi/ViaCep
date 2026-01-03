package principal;

import java.util.Scanner;

public class PrincialCep {
    public static void main(String[] args) {

        Scanner cep = new Scanner(System.in);
        System.out.println("Digite o cep do destino.");
        var buscar = cep.nextLine();

        String endereco = "https://viacep.com.br/ws/" + buscar + "/json/";


    }
}
