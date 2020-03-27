Feature: Credit Assessment Calculator
  This is a simple credit assessment calculator feature for software engineer candidates

  Scenario Outline: Calculate Credit Assessment Score
    When The calculateCreditAssessmentScore API is called with parameters "<numberOfEmployees>", "<companyType>", "<numberOfYearsOperated>"
    Then The credit assessment score should match "<result>"

  Examples:
    | numberOfEmployees | companyType | numberOfYearsOperated | result |
    | 1 | Sole Proprietorship | 0 | 12 |
    | 1 | Limited Liability Company | 0 | 63 |
    | 1 | Partnership | 0 | 75 |
    | 1 | Others | 0 | 0 |

    | 1 | Others | 0  | 0 |
    | 1 | Others | 1  | 0 |
    | 1 | Others | 3  | 0 |
    | 1 | Others | 4  | 28 |
    | 1 | Others | 6  | 28 |
    | 1 | Others | 9  | 28 |
    | 1 | Others | 10 | 36 |
    | 1 | Others | 12 | 36 |
    | 1 | Others | 15 | 36 |
    | 1 | Others | 16 | 59 |
    | 1 | Others | 38 | 59 |

    | 1 | Others | 0  | 0 |
    | 2 | Others | 0  | 0 |
    | 5 | Others | 0  | 0 |
    | 6 | Others | 0  | 20 |
    | 8 | Others | 0  | 20 |
    | 10 | Others | 0  | 20 |
    | 11 | Others | 0  | 32 |
    | 13 | Others | 0  | 32 |
    | 15 | Others | 0  | 32 |
    | 16 | Others | 0  | 55 |
    | 18 | Others | 0  | 55 |
    | 20 | Others | 0  | 55 |
    | 21 | Others | 0  | 70 |
    | 58 | Others | 0  | 70 |

    | 6 | Sole Proprietorship | 5 | 60 |
    | 10 | Limited Liability Company | 8 | 111 |
