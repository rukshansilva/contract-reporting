package com.oracle.reporting.output;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.impl.ReportingOutputGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingOutputGeneratorTest {

    private static ReportingOutputGenerator reportingOutputGenerator = null;

    @BeforeAll
    public static void setup() {
        reportingOutputGenerator = new ReportingOutputGenerator();
    }

    @Test
    void calcTotalCustomerIdsPerContractIdTest() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(buildCsvContractDataObjects()).
                        size() , 2),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(buildCsvContractDataObjects()).
                         get(2345L), 3),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerContractId(buildCsvContractDataObjects()).
                        get(2346L), 2));

    }

    @Test
    void calcTotalCustomerIdsPerGeozoneTest() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        size() , 3),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("us_east"), 1),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("us_west"), 2),
                () -> assertEquals(reportingOutputGenerator.calcTotalCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("eu_west"), 2));
    }

    @Test
    void calcAvgBuilddurationPerGeozoneTest() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(buildCsvContractDataObjects()).
                        size() , 3),
                () -> assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(buildCsvContractDataObjects()).
                        get("us_east"), 3445.0),
                () -> assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(buildCsvContractDataObjects()).
                        get("us_west"), 2216.0),
                () -> assertEquals(reportingOutputGenerator.calcAvgBuilddurationPerGeozone(buildCsvContractDataObjects()).
                        get("eu_west"), 4222.0));
    }

    @Test
    void printCustomerIdsPerGeozoneTest() {

        assertAll(
                () ->  assertEquals(reportingOutputGenerator.getCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        size() , 3),
                () -> assertEquals(reportingOutputGenerator.getCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("us_east"), Arrays.asList(2343225L)),
                () -> assertEquals(reportingOutputGenerator.getCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("us_west"), Arrays.asList(1223456L, 1233456L)),
                () -> assertEquals(reportingOutputGenerator.getCustomerIdsPerGeozone(buildCsvContractDataObjects()).
                        get("eu_west"), Arrays.asList(3244332L, 3244132L)));
    }

    private List<CsvContractDataDto> buildCsvContractDataObjects () {

        return Arrays.asList(
                CsvContractDataDto.
                        builder().
                        customerId(2343225L).
                        contractId(2345L).
                        geozone("us_east").
                        teamcode("RedTeam").
                        projectcode("ProjectApple").
                        buildduration(3445D),
                CsvContractDataDto.
                        builder().
                        customerId(1223456L).
                        contractId(2345L).
                        geozone("us_west").
                        teamcode("BlueTeam").
                        projectcode("ProjectBanana").
                        buildduration(2211D),
                CsvContractDataDto.
                        builder().
                        customerId(3244332L).
                        contractId(2346L).
                        geozone("eu_west").
                        teamcode("YellowTeam").
                        projectcode("ProjectDate").
                        buildduration(4322D),
                CsvContractDataDto.
                        builder().
                        customerId(1233456L).
                        contractId(2345L).
                        geozone("us_west").
                        teamcode("BlueTeam").
                        projectcode("ProjectDate").
                        buildduration(2221D),
                CsvContractDataDto.
                        builder().
                        customerId(3244132L).
                        contractId(2346L).
                        geozone("eu_west").
                        teamcode("YellowTeam").
                        projectcode("ProjectEgg").
                        buildduration(4122D));
    }
}
