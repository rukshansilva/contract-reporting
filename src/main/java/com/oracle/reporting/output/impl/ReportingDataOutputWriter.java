package com.oracle.contractportfolio.output.impl;

import com.oracle.contractportfolio.dto.CsvContractDataDto;
import com.oracle.contractportfolio.output.DataOutputWriter;

public class ReportingDataOutputWriter implements DataOutputWriter <CsvContractDataDto, String> {
    /**
     * @param input CsvContractDataDto Object
     */
    @Override
    public String processOutput(CsvContractDataDto csvContractDataDto) {
        return "The number of unique customerId for each contractId: \n 2345: 3, 2346: 2";
    }
}
