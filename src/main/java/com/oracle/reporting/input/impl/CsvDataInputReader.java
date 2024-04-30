package com.oracle.reporting.input.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.input.DataInputReader;

import java.util.Arrays;
import java.util.List;

/**
 * CSV input Reader
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class CsvDataInputReader implements DataInputReader <String, List<CsvContractDataDto>>{

    /**
     * @param fileName input Filename
     * @return CsvContractDataDto Object List
     */
    @Override
    public List<CsvContractDataDto> processInput(String fileName) {
        return Arrays.asList(new CsvContractDataDto());
    }
}
