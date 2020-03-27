package com.serai.service;

import com.serai.exception.InvalidInputException;
import com.serai.model.CreditScoreInputs;

public interface CreditCalculationService {
    Integer calculateCreditScore(CreditScoreInputs creditScoreInputs) throws InvalidInputException;
}
