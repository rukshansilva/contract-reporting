package com.oracle.reporting.service.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.factory.DataInputBuilderFactory;
import com.oracle.reporting.factory.DataInputReaderFactory;
import com.oracle.reporting.factory.DataOutputWriterFactory;
import com.oracle.reporting.input.DataInputBuilder;
import com.oracle.reporting.input.DataInputReader;
import com.oracle.reporting.output.DataOutputWriter;
import com.oracle.reporting.service.ContractPortfolioService;
import com.oracle.reporting.util.constant.FactoryEnum;
import com.oracle.reporting.util.exception.ContractReportingGenericException;

import java.util.List;

/**
 * Contract Portfolio Service class.
 * Handles the business logic in reading the input and processing the output.
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ContractPortfolioServiceImpl implements ContractPortfolioService<String> {

    /**
     * Generates the contract report
     *
     * @param Input data
     * @return a Success or a Failure
     */
    @Override
    public Boolean generateContractReport(String csvInput) {

        //Build the Input
        DataInputReader inputReader = DataInputReaderFactory.getInstance(FactoryEnum.DATA_INPUT_READER_CSV);
        List<List<String>> csvInputLinesData;
        try {
            csvInputLinesData = (List<List<String>>) inputReader.processInput(csvInput);

        } catch (ContractReportingGenericException e) {
            System.err.println(String.format("Error while reading the input : %s", e.getMessage()));
            return Boolean.FALSE;
        }

        DataInputBuilder csvDataInputBuilder = DataInputBuilderFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV);
        List<CsvContractDataDto> csvContractDataDtoList;

        try {
            csvContractDataDtoList = (List<CsvContractDataDto>) csvDataInputBuilder.buildDataObject(csvInputLinesData);
        } catch (ContractReportingGenericException e) {
            System.err.println(String.format("Error while reading the input : %s", e.getMessage()));
            return Boolean.FALSE;
        }

        //Generate the Report
        DataOutputWriter reportingDataOutputWriter = DataOutputWriterFactory.getInstance(FactoryEnum.DATA_OUTPUT_WRITER_REPORTING);
        String outputString = (String) reportingDataOutputWriter.processOutput(csvContractDataDtoList);

        //Print the Report
        System.out.println(outputString);
        return Boolean.TRUE;
    }
}
