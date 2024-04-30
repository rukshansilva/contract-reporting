package com.oracle.reporting.input;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.input.impl.CsvDataInputReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CsvDataInputReaderTest {

	@Test
	public void testProcessInput() {

		assertEquals(new CsvDataInputReader().processInput("C:/test.csv").getCustomerId(), new CsvContractDataDto().getCustomerId());
	}

}
