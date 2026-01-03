package principal;

import modelos.Endereco;
import service.ViaCepService;

import java.util.Scanner;

public class PrincipalCep {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ViaCepService service = new ViaCepService();

        System.out.println("Digite o CEP:");
        String cep = scanner.nextLine().replace("-", "");

        Endereco endereco = service.buscarEndereco(cep);

        if (endereco == null || endereco.isErro()) {
            System.out.println("CEP inválido ou não encontrado.");
        } else {
            System.out.println(endereco);
        }

        scanner.close();
    }
}
