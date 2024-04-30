package com.oracle.reporting.util.exception;

/**
 * Generic exception class
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractReportingGenericException extends Exception {

    public ContractReportingGenericException(String message) {
        super(message);
    }

    public ContractReportingGenericException(Throwable throwable) {
        super(throwable);
    }

    public ContractReportingGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
