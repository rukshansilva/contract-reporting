package com.oracle.reporting.util.exception;

/**
 * Generic exception class
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractPortfolioGenericException extends Exception {

    public ContractPortfolioGenericException(String message) {
        super(message);
    }

    public ContractPortfolioGenericException(Throwable throwable) {
        super(throwable);
    }

    public ContractPortfolioGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
