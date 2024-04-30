package com.oracle.reporting.output;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.impl.ReportingOutputGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingOutputGeneratorTest {

    private static ReportingOutputGenerator reportingOutputGenerator = null;

    @BeforeAll
    public static void setup() {
        reportingOutputGenerator = new ReportingOutputGenerator();
    }

    @Test
    void calcTotalCustomerIdsPerContractId() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(
                Arrays.asList(new CsvContractDataDto())).size() , 0),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(
                        Arrays.asList(new CsvContractDataDto())).keySet().size() , 0));

    }

    @Test
    void calcTotalCustomerIdsPerGeozone() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(
                        Arrays.asList(new CsvContractDataDto())).size() , 0),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(
                        Arrays.asList(new CsvContractDataDto())).keySet().size() , 0));
    }

    @Test
    void calcAvgBuilddurationPerGeozone() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(
                        Arrays.asList(new CsvContractDataDto())).size() , 0),
                () -> assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(
                        Arrays.asList(new CsvContractDataDto())).keySet().size() , 0));
    }

    @Test
    void printCustomerIdsPerGeozone() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.printCustomerIdsPerGeozone(
                        Arrays.asList(new CsvContractDataDto())).size() , 0),
                () -> assertEquals(reportingOutputGenerator.printCustomerIdsPerGeozone(
                        Arrays.asList(new CsvContractDataDto())).keySet().size() , 0));
    }
}
