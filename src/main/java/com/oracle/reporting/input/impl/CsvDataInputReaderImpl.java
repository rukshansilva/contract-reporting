package com.oracle.reporting.input.impl;

import com.oracle.reporting.input.DataInputReader;
import com.oracle.reporting.util.exception.ContractReportingGenericException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CSV input Reader
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class CsvDataInputReaderImpl implements DataInputReader<String, List<List<String>> >{

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    //Newline char
    private static final  String NEW_LINE_SEPARATOR = "\\\\n";

    /**
     * Process the String input
     * @param input lines data
     * @return List of CsvContractDataDto
     */
    @Override
    public  List<List<String>> processInput(String csvInput) throws ContractReportingGenericException {

        if(csvInput == null ) {
            throw new ContractReportingGenericException("Malformed CSV data - Blank CSV data");
        }

        //Split CSV data
        String[] csvInputLines = csvInput.split(NEW_LINE_SEPARATOR);

        if(csvInputLines == null || csvInputLines.length == 0 ||
                (csvInputLines.length > 0 && csvInputLines[0].isEmpty())) {
            throw new ContractReportingGenericException("Malformed CSV data - No data found");
        }

        List<List<String>> csvInputLinesData = new ArrayList<>();

        for (String line: csvInputLines) {

            String[] csvInputValues = line.split(COMMA_DELIMITER);

            if(csvInputValues.length != 6) {
                throw new ContractReportingGenericException("Malformed CSV data - Incomplete file");
            }

            csvInputLinesData.add(Arrays.asList(csvInputValues).stream().map(v -> v.strip()).collect(Collectors.toList()));
        }

        return csvInputLinesData;
    }
}
