package com.oracle.contractportfolio.input.impl;

import com.oracle.contractportfolio.dto.CsvContractDataDto;
import com.oracle.contractportfolio.input.DataInputReader;

public class CsvDataInputReader implements DataInputReader <String, CsvContractDataDto>{

    /**
     * @param input input Filename
     * @return CsvContractDataDto Object
     */
    @Override
    public CsvContractDataDto processInput(String input) {
        return new CsvContractDataDto();
    }
}
