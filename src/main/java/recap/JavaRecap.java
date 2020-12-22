package recap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import com.google.gson.Gson;
import gui.FPLGui;
import serialization.FPLBootstrapStatic;
import serialization.FPLTeamHistory;

public class JavaRecap {
    private static String BOOTSTRAP_STATIC_URI = "https://fantasy.premierleague.com/api/bootstrap-static/";
    private static String TEAM_HISTORY_URI = "https://fantasy.premierleague.com/api/entry/%s/history/";
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BOOTSTRAP_STATIC_URI))
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            FPLBootstrapStatic bootstrapData = gson.fromJson(response.body(), FPLBootstrapStatic.class);

            FPLGui gui = new FPLGui(bootstrapData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
