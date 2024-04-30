package com.oracle.reporting.input;

import com.oracle.reporting.input.impl.CsvDataInputReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CsvDataInputReaderTest {

		private static CsvDataInputReader csvDataInputReader = null;

		@BeforeAll
		public static void setup() {
			csvDataInputReader = new CsvDataInputReader();
		}

		@Test
		public void testProcessInput() {

			assertAll(
					() -> assertEquals(csvDataInputReader.processInput("C:/test.csv").size(), 1),
					() -> assertNull(csvDataInputReader.processInput("C:/test.csv").stream().findFirst().get().getCustomerId()));
		}
}
