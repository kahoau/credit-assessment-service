package com.serai.service.impl;


import com.serai.config.CreditCalculationConfig;
import com.serai.exception.InvalidInputException;
import com.serai.model.CreditScoreInputs;
import com.serai.service.CreditCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CreditCalculationServiceImpl implements CreditCalculationService {
    @Autowired
    private CreditCalculationConfig creditCalculationConfig;

    public Integer calculateCreditScore(CreditScoreInputs creditScoreInputs) throws InvalidInputException {
        return  determineScore(creditCalculationConfig.getCompanyTypes(), creditScoreInputs.getCompanyType()) +
                determineScore(creditCalculationConfig.getNumOfEmployees(), creditScoreInputs.getNumberOfEmployees()) +
                determineScore(creditCalculationConfig.getTimeInBusinesses(), creditScoreInputs.getNumberOfYearsOperated());
    }

    private Integer determineScore(final List<CreditCalculationConfig.CompanyType> companyTypes, String theCompanyType) {
        CreditCalculationConfig.CompanyType companyType = companyTypes.stream().filter( x ->
                x.getType().equalsIgnoreCase(theCompanyType)).findFirst().orElse(null);

        if (companyType == null) { throw new InvalidInputException("Invalid Input Type"); }
        return companyType.getScore();
    }

    private Integer determineScore(final List<CreditCalculationConfig.ScoreModel> scoreModels,
                                                              int theScore) throws InvalidInputException {
        CreditCalculationConfig.ScoreModel theModel = scoreModels.stream().filter(
                x -> x.getFrom() <= theScore && x.getTo() >= theScore).findFirst().orElse(null);

        if (theModel == null) { throw new InvalidInputException("Invalid Input Range"); }
        return theModel.getScore();
    }
}
