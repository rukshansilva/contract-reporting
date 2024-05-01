package com.oracle.reporting.input.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.input.DataInputBuilder;
import com.oracle.reporting.util.exception.ContractReportingGenericException;

import java.util.ArrayList;
import java.util.List;

/**
 * CSV input Builder
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class CsvDataInputBuilderImpl implements DataInputBuilder<List<List<String>>, List<CsvContractDataDto>> {

    /**
     * Builds the Data Object
     * @param input lines data
     * @return List of CsvContractDataDto
     */
    @Override
    public List<CsvContractDataDto> buildDataObject(List<List<String>> csvInputLinesData) throws ContractReportingGenericException {

        if(csvInputLinesData == null || csvInputLinesData.isEmpty() ||
                (csvInputLinesData != null && csvInputLinesData.stream().findAny().isEmpty())) {
            throw new ContractReportingGenericException("No data found in input file or the data has been corrupted");
        }

        List<CsvContractDataDto> csvContractDataDtoList = new ArrayList<>(csvInputLinesData.size());

        try {

            //Build CsvContractDataDto Object list
            for (List<String> csvInputData : csvInputLinesData) {

                csvContractDataDtoList.add(CsvContractDataDto.
                        builder().
                        customerId(Long.parseLong(csvInputData.get(0))).
                        contractId(Long.parseLong(csvInputData.get(1))).
                        geozone(csvInputData.get(2)).
                        teamcode(csvInputData.get(3)).
                        projectcode(csvInputData.get(4)).
                        //Remove the seconds character in buildduration
                        buildduration(Double.parseDouble(csvInputData.get(5).substring(0, csvInputData.get(5).length() - 1))));
            }
        } catch (Exception e) {
            throw new ContractReportingGenericException(
                    String.format("Malformed CSV data - unable to read data in expected format: %s", e.getMessage()), e);
        }

        return csvContractDataDtoList;
    }
}
