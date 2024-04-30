package com.oracle.reporting.output;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingDataOutputWriterTest {

    private static ReportingDataOutputWriter reportingDataOutputWriter = null;

    @BeforeAll
    public static void setup() {
        reportingDataOutputWriter = new ReportingDataOutputWriter();
    }

    @Test
    public void testProcessOutput() {

        assertEquals(reportingDataOutputWriter.processOutput(Arrays.asList(new CsvContractDataDto())),
                "The number of unique customerId for each contractId: \n 2345: 3, 2346: 2");
    }
}
