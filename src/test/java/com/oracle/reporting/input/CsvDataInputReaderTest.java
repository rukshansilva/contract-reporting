package com.oracle.reporting.input;

import com.oracle.reporting.input.impl.CsvDataInputReaderImpl;
import com.oracle.reporting.util.exception.ContractReportingGenericException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvDataInputReaderTest {

		private final String successInput = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\\n" +
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\\n" +
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\\n" +
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\\n" +
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

		private final String incompleteDataFailureInput = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\\n" +
					"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\\n" +
					"3244332,2346,eu_west,YellowTeam3,ProjectCarrot\\n" +
					"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\\n" +
					"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

		private static DataInputReader csvDataInputReader = null;

		@BeforeAll
		public static void setup() {
			csvDataInputReader = new CsvDataInputReaderImpl();
		}

		@Test
		public void testProcessInputSuccess() {

			assertAll(
					() -> assertNotNull(csvDataInputReader.processInput(successInput)),
					() -> assertEquals(((List<List<String>>)csvDataInputReader.processInput(successInput)).size(), 5));
		}

		@Test
		public void testProcessInputIncompleteDataFailure() {

			Throwable exception =  assertThrows(ContractReportingGenericException.class,
					() -> csvDataInputReader.processInput(incompleteDataFailureInput));

			assertEquals(exception.getMessage(), "Malformed CSV data - Incomplete file");
		}

		@Test
		public void testProcessInputNullFailure() {

			Throwable exception =  assertThrows(ContractReportingGenericException.class,
					() -> csvDataInputReader.processInput(null));

			assertEquals(exception.getMessage(), "Malformed CSV data - Blank CSV data");
		}

		@Test
		public void testProcessInputNoDataFailure() {

			Throwable exception =  assertThrows(ContractReportingGenericException.class,
					() -> csvDataInputReader.processInput(""));

			assertEquals(exception.getMessage(), "Malformed CSV data - No data found");
		}

}
