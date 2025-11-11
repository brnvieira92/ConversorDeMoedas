package modulos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonParser {
    public JsonObject extrairTaxas(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject objetoJson = gson.fromJson(json, JsonObject.class);
        return objetoJson.getAsJsonObject("conversion_rates");
    }
}

