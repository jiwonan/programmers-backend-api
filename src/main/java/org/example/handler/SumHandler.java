package org.example.handler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.dto.User;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class SumHandler implements HttpHandler {
    private final String projectDir = System.getProperty("user.dir");

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String path = projectDir + "/data/input/user.json";
            ObjectMapper om = new ObjectMapper();

            User[] users = om.readValue(new File(path), User[].class);
            om.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

            int sum = 0;
            for(User user:users) {
                sum += Integer.parseInt(user.getPost_count());
            }

            System.out.println(sum);

            String response = """
                {
                    "sum": %d
                }
                """.formatted(sum);

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(500, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
