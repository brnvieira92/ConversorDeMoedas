package modulos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner = new Scanner(System.in);

    public String lerMoedaBase() {
        System.out.println("Digite a moeda de origem (ex: USD, BRL):");
        return scanner.nextLine().toUpperCase();
    }

    public double lerValor() {
        System.out.println("Digite o valor a converter (ou 0 para sair):");
        return scanner.nextDouble();
    }

    public String lerMoedaDestino() {
        System.out.println("Digite a moeda destino:");
        return scanner.next().toUpperCase();
    }

    public void mostrarTaxas(String base, String[] moedas, JsonObject taxas) {
        System.out.println("Taxas em relação a " + base + ":");
        for (String moeda : moedas) {
            if (taxas.has(moeda)) {
                double valor = taxas.get(moeda).getAsDouble();
                System.out.println(moeda + ": " + valor);
            }
        }
    }

    public void mostrarResultado(double valor, String origem, double convertido, String destino) {
        System.out.printf("%.2f %s = %.2f %s%n", valor, origem, convertido, destino);
    }

    public void mostrarErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }
}
