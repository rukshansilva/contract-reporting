package com.oracle.reporting.output;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingDataOutputWriterTest {

    private final String successOutput = "The number of unique customerId for each contractId : \n" +
            "2345 - 3\n" +
            "2346 - 2\n" +
            "The number of unique customerId for each geozone : \n" +
            "eu_west - 2\n" +
            "us_west - 2\n" +
            "us_east - 1\n" +
            "The average buildduration for each geozone : \n" +
            "eu_west - 4222.0\n" +
            "us_west - 2216.0\n" +
            "us_east - 3445.0\n" +
            "The list of unique customerId for each geozone : \n" +
            "eu_west - [3244332, 3244132]\n" +
            "us_west - [1223456, 1233456]\n" +
            "us_east - [2343225]";
    private static DataOutputWriter reportingDataOutputWriter = null;

    @BeforeAll
    public static void setup() {
        reportingDataOutputWriter = new ReportingDataOutputWriter();
    }

    @Test
    public void testProcessOutput() {

        assertEquals(reportingDataOutputWriter.processOutput(buildCsvContractDataObjects()), successOutput);
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
