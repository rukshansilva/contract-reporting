package com.oracle.reporting.input;

import com.oracle.reporting.util.exception.ContractReportingGenericException;

/**
 * CSV input builder
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataInputBuilder<I ,R> {

    /**
     * Builds the Data Object
     */
    R buildDataObject(I inputData) throws ContractReportingGenericException;
}
