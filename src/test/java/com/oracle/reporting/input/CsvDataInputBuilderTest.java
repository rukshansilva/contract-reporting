package com.oracle.reporting.input;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.input.impl.CsvDataInputBuilder;
import com.oracle.reporting.util.exception.ContractReportingGenericException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvDataInputBuilderTest {

		private static CsvDataInputBuilder csvDataInputBuilder = null;

		@BeforeAll
		public static void setup() {
			csvDataInputBuilder = new CsvDataInputBuilder();
		}

		@Test
		public void testBuildDataObjectError() {

			Throwable exception =  assertThrows(ContractReportingGenericException.class,
					() -> csvDataInputBuilder.buildDataObject(Collections.EMPTY_LIST));

			assertEquals(exception.getMessage(), "No data found in input file or the data has been corrupted");
		}

		@Test
		public void testBuildDataObjectSuccess() {

			try {
				assertNull(csvDataInputBuilder.buildDataObject(
						Arrays.asList(Arrays.asList("12345", "2345"))).stream().findFirst().get().getCustomerId());

			} catch (ContractReportingGenericException e) {
				throw new RuntimeException(e);
			}
		}
}
