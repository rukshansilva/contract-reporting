package com.oracle.reporting.output.impl;

import com.oracle.reporting.dto.CsvContractDataDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Reporting data output generator
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ReportingOutputGenerator {

    /**
     * Calculates The number of unique customerId for each contractId
     * @param List of CsvContractDataDto
     * @return Output Map
     */
    public Map<Long, Long> calcTotalCustomerIdsPerContractId(List<CsvContractDataDto> csvContractDataList) {

        //Map of ContractId, Number of Unique Customer Ids
        return csvContractDataList.stream().collect(Collectors.groupingBy(CsvContractDataDto::getContractId)).
                entrySet().stream().collect(Collectors.toMap(e-> e.getKey(),
                        e -> e.getValue().stream().map(CsvContractDataDto::getCustomerId).distinct().collect(Collectors.counting())));

    }

    /**
     * Calculates The number of unique customerId for each geozone
     * @param List of CsvContractDataDto
     * @return Output Map
     */
    public Map<String, Long> calcTotalCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, Number of Unique Customer Ids
        return csvContractDataList.stream().collect(Collectors.groupingBy(CsvContractDataDto::getGeozone)).
                entrySet().stream().collect(Collectors.toMap(e-> e.getKey(),
                        e -> e.getValue().stream().map(CsvContractDataDto::getCustomerId).distinct().collect(Collectors.counting())));

    }

    /**
     * Calculates The average buildduration for each geozone
     * @param List of CsvContractDataDto
     * @return Output Map
     */
    public Map<String, Double> calcAvgBuilddurationPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, Average Buildduration
        return csvContractDataList.stream().collect(Collectors.groupingBy(CsvContractDataDto::getGeozone)).
                entrySet().stream().collect(Collectors.toMap(e-> e.getKey(),
                        e -> e.getValue().stream().mapToDouble(CsvContractDataDto::getBuildduration).average().orElse(0.0)));
    }

    /**
     * Calculates The list of unique customerId for each geozone
     * @param List of CsvContractDataDto
     * @return Output Map
     */
    public Map<String, List<Long>> getCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, List of Unique Customer Ids
        return csvContractDataList.stream().collect(Collectors.groupingBy(CsvContractDataDto::getGeozone)).
                entrySet().stream().collect(Collectors.toMap(e-> e.getKey(),
                        e -> e.getValue().stream().map(CsvContractDataDto::getCustomerId).distinct().collect(Collectors.toList())));
    }
}
