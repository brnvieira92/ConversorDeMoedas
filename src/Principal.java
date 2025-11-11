import com.google.gson.JsonObject;
import modulos.ApiClient;
import modulos.ConversorDeMoeda;
import modulos.InterfaceUsuario;
import modulos.JsonParser;

public class Principal {
    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        ApiClient api = new ApiClient();
        JsonParser parser = new JsonParser();
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        try {
            String moedaBase = ui.lerMoedaBase();
            String json = api.buscarDados(moedaBase);
            JsonObject taxas = parser.extrairTaxas(json);

            String[] moedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
            ui.mostrarTaxas(moedaBase, moedas, taxas);

            while (true) {
                double valor = ui.lerValor();
                if (valor == 0) break;

                String destino = ui.lerMoedaDestino();
                if (taxas.has(destino)) {
                    double convertido = conversor.converter(valor, destino, taxas);
                    ui.mostrarResultado(valor, moedaBase, convertido, destino);
                } else {
                    ui.mostrarErro("Moeda não encontrada.");
                }
            }

        } catch (Exception e) {
            ui.mostrarErro("Falha na execução: " + e.getMessage());
        }
    }
}
