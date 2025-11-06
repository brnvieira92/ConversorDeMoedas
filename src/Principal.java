import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("ARS, BOB, BRL, CLP, COP, USD");
        System.out.println("Digite a moeda desejada: ");
        String par = leitor.nextLine().toUpperCase();
        var endereco = "https://v6.exchangerate-api.com/v6/801b5ea2ec19de0890aa54dd/latest/" + par;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        System.out.println(json);

        JsonObject rates = json.getAsJsonObject("conversion_rates");
        double brl = rates.get("BRL").getAsDouble();
        double ars = rates.get("BOB").getAsDouble();
        double clp = rates.get("CLP").getAsDouble();
        double cop = rates.get("COP").getAsDouble();
        double usd = rates.get("USD").getAsDouble();
        double bob = rates.get("BOB").getAsDouble();

        String[] moedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        System.out.println("Taxas em relação a " + par + ":");
        for (String moeda : moedas) {
            if (rates.has(moeda)) {
                double valor = rates.get(moeda).getAsDouble();
                System.out.println(moeda + ": " + valor);
            }
        }
    }
}
