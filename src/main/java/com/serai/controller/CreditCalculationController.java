package com.serai.controller;


import com.serai.exception.InvalidInputException;
import com.serai.model.CreditScoreInputs;
import com.serai.service.CreditCalculationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static com.serai.controller.CreditCalculationController.Links.CALCULATE_CREDIT_SCORE;


@RestController
public class CreditCalculationController {
    @Autowired
    private CreditCalculationService creditCalculationService;

    @ApiOperation(value = "To calculate credit score based on the input of Company Type, Number of Employees and Time in Business",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "calculateCreditScore ok"),
            @ApiResponse(code = 400, message = "Invalid Input format/range")
    })
    @PostMapping(CALCULATE_CREDIT_SCORE)
    public Integer calculateCreditScore(@RequestBody CreditScoreInputs creditScoreInputs) throws InvalidInputException {
        return creditCalculationService.calculateCreditScore(creditScoreInputs);
    }

    @UtilityClass
    public static class Links {
        public static final String CALCULATE_CREDIT_SCORE = "/calculateCreditScore";
    }
}
