package com.serai.bdd.steps;

import com.serai.bdd.BaseHttpClient;
import com.serai.model.CreditScoreInputs;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleCreditCalculatorSteps {
    @Autowired
    private BaseHttpClient bagHttpClient;

    private ResponseEntity<Integer> response;


    @When("^The calculateCreditAssessmentScore API is called with parameters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void the_calculateCreditAssessmentScore_API_is_called_with_parameters(Integer numberOfEmployees, String companyType, Integer numberOfYearsOperated) throws Throwable {
        CreditScoreInputs creditScoreInputs = CreditScoreInputs.builder()
                .numberOfEmployees(numberOfEmployees).companyType(companyType)
                .numberOfYearsOperated(numberOfYearsOperated).build();
        HttpEntity<CreditScoreInputs> request = new HttpEntity<>(creditScoreInputs);

        response = bagHttpClient.post(request);
    }

    @Then("^The credit assessment score should match \"([^\"]*)\"$")
    public void the_credit_assessment_score_should_match(Integer result) throws Throwable {
        Assert.assertEquals(200,response.getStatusCode().value());
        Assert.assertEquals(result,response.getBody());
    }
}
