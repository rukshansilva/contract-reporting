package com.oracle.reporting.output;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportingDataOutputWriterTest {

    @Test
    public void testProcessOutput() {

        assertEquals(new ReportingDataOutputWriter().processOutput(new CsvContractDataDto()), "The number of unique customerId for each contractId: \n 2345: 3, 2346: 2");
    }
}
