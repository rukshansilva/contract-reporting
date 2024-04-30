package com.oracle.reporting.service;

import com.oracle.reporting.service.impl.ContractPortfolioServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractPortfolioServiceTest {

    @Test
    public void testIntegratedFlow() {

        assertEquals(new ContractPortfolioServiceImpl().generateContractReport("C:/test.csv"),
                Boolean.TRUE);
    }
}
