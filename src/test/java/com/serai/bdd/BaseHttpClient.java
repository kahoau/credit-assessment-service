package com.serai.bdd;

import com.serai.model.CreditScoreInputs;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static com.serai.controller.CreditCalculationController.Links.CALCULATE_CREDIT_SCORE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BaseHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String CONTEXT_PATH = "/credit-assessment-service";
    private final String THINGS_ENDPOINT = CONTEXT_PATH + CALCULATE_CREDIT_SCORE;


    @LocalServerPort
    private int port;
    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    private String calculateCreditScoreEndpoint() {
        return SERVER_URL + ":" + port + THINGS_ENDPOINT;
    }

    public ResponseEntity<Integer> post(HttpEntity<CreditScoreInputs> request) {
        return testRestTemplate.exchange(calculateCreditScoreEndpoint(), HttpMethod.POST, request, Integer.class);
    }
}
