package net.cserny.poc.guicespark;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final HelloMessageService helloMessageService;
    private final ObjectMapper objectMapper;

    @Inject
    public Application(HelloMessageService helloMessageService, ObjectMapper objectMapper) {
        this.helloMessageService = helloMessageService;
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        Guice.createInjector(new GuiceModule())
                .getInstance(Application.class)
                .run(9999);
    }

    public void run(int port) {
        port(port);

        before("/*", (req, res) -> LOGGER.info(String.format("%s: %s",
                req.requestMethod(), req.uri())));

        get("/", (req, res) -> {
            HelloMessage message = helloMessageService.sayHello();
            res.header("Content-Type", "application/json");
            return objectMapper.writeValueAsString(message);
        });

        after("/*", (req, res) -> LOGGER.info(res.body()));
    }
}
