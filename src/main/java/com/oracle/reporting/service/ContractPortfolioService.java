package com.oracle.reporting.service;

/**
 * Contract Portfolio Service Interface.
 * Handles the business logic in reading the input and processing the output.
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface ContractPortfolioService<I> {

    Boolean generateContractReport(I input);
}
