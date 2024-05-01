package com.oracle.reporting.output.impl;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.DataOutputWriter;

import java.util.List;
import java.util.Map;

/**
 * Reporting data output writer
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ReportingDataOutputWriter implements DataOutputWriter<List<CsvContractDataDto>, String> {

    private ReportingOutputGenerator reportingOutputGenerator;

    public ReportingDataOutputWriter() {
        reportingOutputGenerator = new ReportingOutputGenerator();
    }

    /**
     * Process the Output
     * @param List of CsvContractDataDto
     * @return Output String
     */
    @Override
    public String processOutput(List<CsvContractDataDto> csvContractDataList) {

        StringBuilder outputString = new StringBuilder();

        //Map of ContractId, Number of Unique Customer Ids
        this.calcTotalCustomerIdsPerContractId(csvContractDataList, outputString);

        //Map of Geozone, Number of Unique Customer Ids
        this.calcTotalCustomerIdsPerGeozone(csvContractDataList, outputString);

        //Map of Geozone, Average Buildduration
        this.calcAvgBuilddurationPerGeozone(csvContractDataList, outputString);

        //Map of Geozone, List of Unique Customer Ids
        this.getCustomerIdsPerGeozone(csvContractDataList, outputString);

        //Truncate the last \n
        return !outputString.isEmpty() ? outputString.substring(0, outputString.length() - 1) : outputString.toString();
    }

    /**
     * Calculate Total CustomerIds Per ContractId
     * @param List of CsvContractDataDto
     * @param Current output string
     */
    private void calcTotalCustomerIdsPerContractId(List<CsvContractDataDto> csvContractDataList, StringBuilder outputString) {

        //Map of ContractId, Number of Unique Customer Ids
        Map<Long, Long> customerPerContractMap = reportingOutputGenerator.calcTotalCustomerIdsPerContractId(csvContractDataList);

        if(! customerPerContractMap.isEmpty()) {
            outputString.append("The number of unique customerId for each contractId : \n");

            for (Map.Entry<Long, Long> entrySet : customerPerContractMap.entrySet()) {
                outputString.append(entrySet.getKey()).append(" - ").append(entrySet.getValue()).append("\n");
            }
        }
    }

    /**
     * Calculate Total CustomerIds Per Geozone
     * @param List of CsvContractDataDto
     * @param Current output string
     */
    private void calcTotalCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList, StringBuilder outputString) {

        //Map of Geozone, Number of Unique Customer Ids
        Map<String, Long> customerPerGeozoneMap = reportingOutputGenerator.calcTotalCustomerIdsPerGeozone(csvContractDataList);

        if(! customerPerGeozoneMap.isEmpty()) {
            if (! outputString.toString().endsWith("\n")){
                outputString.append("\n");
            }
            outputString.append("The number of unique customerId for each geozone : \n");

            for (Map.Entry<String, Long> entrySet : customerPerGeozoneMap.entrySet()) {
                outputString.append(entrySet.getKey()).append(" - ").append(entrySet.getValue()).append("\n");
            }
        }
    }

    /**
     * Calculate Average Buildduration Per Geozone
     * @param List of CsvContractDataDto
     * @param Current output string
     */
    private void calcAvgBuilddurationPerGeozone(List<CsvContractDataDto> csvContractDataList, StringBuilder outputString) {

        //Map of Geozone, Average Buildduration
        Map<String, Double> avgBuilddurationPerGeozoneMap = reportingOutputGenerator.calcAvgBuilddurationPerGeozone(csvContractDataList);

        if(! avgBuilddurationPerGeozoneMap.isEmpty()) {
            if (! outputString.toString().endsWith("\n")){
                outputString.append("\n");
            }
            outputString.append("The average buildduration for each geozone : \n");

            for (Map.Entry<String, Double> entrySet : avgBuilddurationPerGeozoneMap.entrySet()) {
                outputString.append(entrySet.getKey()).append(" - ").append(entrySet.getValue()).append("\n");
            }
        }
    }

    /**
     * Finds all CustomerIds Per Geozone
     * @param List of CsvContractDataDto
     * @param Current output string
     */
    private void getCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList, StringBuilder outputString) {

        //Map of Geozone, List of Unique Customer Ids
        Map<String, List<Long>> customerIdsPerGeozoneMap = reportingOutputGenerator.getCustomerIdsPerGeozone(csvContractDataList);

        if(! customerIdsPerGeozoneMap.isEmpty()) {
            if (! outputString.toString().endsWith("\n")){
                outputString.append("\n");
            }
            outputString.append("The list of unique customerId for each geozone : \n");

            for (Map.Entry<String, List<Long>> entrySet : customerIdsPerGeozoneMap.entrySet()) {
                outputString.append(entrySet.getKey()).append(" - ").append(entrySet.getValue()).append("\n");
            }
        }
    }
}
