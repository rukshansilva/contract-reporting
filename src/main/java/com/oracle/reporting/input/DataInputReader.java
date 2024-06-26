package com.oracle.reporting.input;

import com.oracle.reporting.util.exception.ContractReportingGenericException;

/**
 * Input Data Reader Interface
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataInputReader<I, R> {

    /**
     * Process the input
     */
    R processInput(I input) throws ContractReportingGenericException;
}
