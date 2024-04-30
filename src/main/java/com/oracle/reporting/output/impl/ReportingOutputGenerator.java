package com.oracle.contractportfolio.output.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportingOutputGenerator {

    protected Map<Long, Integer> calcTotalCustomerIdsPerContractId() {

        //Map of ContractId, Number of Unique Customer Ids

        return new HashMap<>();
    }

    protected Map<String, Integer> calcTotalCustomerIdsPerGeozone() {

        //Map of Geozone, Number of Unique Customer Ids

        return new HashMap<>();
    }

    protected Map<String, Integer> calcAvgBuilddurationPerGeozone() {

        //Map of Geozone, Average Buildduration

        return new HashMap<>();
    }

    protected Map<String, List<Long>>  printCustomerIdsPerGeozone() {

        //Map of Geozone, List of Unique Customer Ids

        return new HashMap<>();
    }
}
