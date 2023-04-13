package com.epam.testautomation.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static java.util.Objects.requireNonNull;

@ComponentScan()
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"wiremock.reset-mappings-after-each-test=true"})
@ActiveProfiles({"integrationtest", "test"})
@Slf4j
public abstract class BaseHttpComponent {


    @Autowired
    private Environment environment;

    @Autowired
    protected WebTestClient webTestClient;

    protected abstract Map<String, Runnable> defaultStubs();

    protected void createDefaultStubsForAllEndpoints() {
        defaultStubs().forEach((k, v) -> v.run());
    }

    protected void createDefaultStubsForEndpoints(String... endpoints) {
        if (endpoints.length < 1) {
            throw new IllegalArgumentException("List of endpoints must not be empty");
        }
        for (String endpoint : endpoints) {
            requireNonNull(defaultStubs().get(endpoint), "Stub for the endpoint is not defined: " + endpoint)
                    .run();
        }
    }
}
