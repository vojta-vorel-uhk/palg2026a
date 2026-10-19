package palg.Cviko04.Uloha03.Generators;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RandomNumberApiGenerator implements Generator {
    @Override
    public String getCode() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            String responseBody;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.randomnumberapi.com/api/v1.0/random?min=100000&max=999999&count=1"))
                    .build();
            responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            return responseBody.replace("[", "").replace("]", "").trim();
        } catch (Exception e) {
            throw new RuntimeException("NEPOVEDLO SE");
        }
    }
}
