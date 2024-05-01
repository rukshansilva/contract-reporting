package com.oracle.reporting.factory;

import com.oracle.reporting.service.ContractPortfolioService;
import com.oracle.reporting.service.impl.ContractPortfolioServiceImpl;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Input Reader Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractPortfolioServiceFactory {

    /**
     * @return an Instance of DataInputReader
     */
    public static ContractPortfolioService getInstance(FactoryEnum instance) {

        if(FactoryEnum.CONTRACT_PORTFOLIO_SERVICE.equals(instance)) {
            return new ContractPortfolioServiceImpl();
        }

        return null;
    }
}
