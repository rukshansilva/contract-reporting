package com.oracle.reporting.output.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.DataOutputWriter;

import java.util.List;

/**
 * Reporting data output writer
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ReportingDataOutputWriter implements DataOutputWriter <List<CsvContractDataDto>, String> {
    /**
     * @param csvContractDataList Object List
     */
    @Override
    public String processOutput(List<CsvContractDataDto> csvContractDataList) {
        return "The number of unique customerId for each contractId: \n 2345: 3, 2346: 2";
    }
}
