package com.oracle.reporting.output.impl;

import com.oracle.reporting.dto.CsvContractDataDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reporting data output generator
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class ReportingOutputGenerator {

    public Map<Long, Integer> calcTotalCustomerIdsPerContractId(List<CsvContractDataDto> csvContractDataList) {

        //Map of ContractId, Number of Unique Customer Ids

        return new HashMap<>();
    }

    public Map<String, Integer> calcTotalCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, Number of Unique Customer Ids

        return new HashMap<>();
    }

    public Map<String, Integer> calcAvgBuilddurationPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, Average Buildduration

        return new HashMap<>();
    }

    public Map<String, List<Long>>  printCustomerIdsPerGeozone(List<CsvContractDataDto> csvContractDataList) {

        //Map of Geozone, List of Unique Customer Ids

        return new HashMap<>();
    }
}
