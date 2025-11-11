package modulos;
import com.google.gson.JsonObject;

public class ConversorDeMoeda {
    public double converter(double valor, String destino, JsonObject taxas) {
        double taxa = taxas.get(destino).getAsDouble();
        return valor * taxa;
    }
}
