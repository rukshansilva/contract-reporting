package com.oracle.reporting.input.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.util.exception.ContractReportingGenericException;

import java.util.Arrays;
import java.util.List;

/**
 * CSV input builder
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class CsvDataInputBuilder {

    public List<CsvContractDataDto> buildDataObject(List<List<String>> data) throws ContractReportingGenericException {

        if(data == null || data.isEmpty()) {
            throw new ContractReportingGenericException("No data found in input file or the data has been corrupted");
        }

        return Arrays.asList(new CsvContractDataDto());
    }
}
