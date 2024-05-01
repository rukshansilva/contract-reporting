package com.oracle.reporting.service;

import com.oracle.reporting.service.impl.ContractPortfolioServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractPortfolioServiceTest {

    private static ContractPortfolioServiceImpl contractPortfolioService = null;

    @BeforeAll
    public static void setup() {
        contractPortfolioService = new ContractPortfolioServiceImpl();
    }

    private final String successInput = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\\n" +
            "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\\n" +
            "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\\n" +
            "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\\n" +
            "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

    private final String incompleteDataFailureInput = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\\n" +
            "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\\n" +
            "3244332,2346,eu_west,YellowTeam3,ProjectCarrot\\n" +
            "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\\n" +
            "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

    //Note - This works as a positive integration test
    @Test
    public void testIntegratedFlowSuccess() {

        assertEquals(contractPortfolioService.generateContractReport(successInput), Boolean.TRUE);
    }

    //Note - This works as a negative integration test
    @Test
    public void testIntegratedFlowFailure() {

        assertEquals(contractPortfolioService.generateContractReport(incompleteDataFailureInput), Boolean.FALSE);
    }
}
