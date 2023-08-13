import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Integer sair = 0;

        for (int i = 0; sair != 9; i++) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite um filme para busca: ");
            String pesquisa = entrada.next();

            String endereco = "https://www.omdbapi.com/?t=" + pesquisa + "&apikey=ea0adec7";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            System.out.println("\nDigite 9 para sair ou qualquer outro numero para continuar: ");
            sair = entrada.nextInt();
        }
    }
}
