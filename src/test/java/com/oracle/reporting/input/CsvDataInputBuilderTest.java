package com.oracle.reporting.input;

import com.oracle.reporting.dto.CsvContractDataDto;
import com.oracle.reporting.input.impl.CsvDataInputBuilderImpl;
import com.oracle.reporting.util.exception.ContractReportingGenericException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvDataInputBuilderTest {

		private static DataInputBuilder csvDataInputBuilder = null;

		@BeforeAll
		public static void setup() {
			csvDataInputBuilder = new CsvDataInputBuilderImpl();
		}

		@Test
		public void testBuildDataObjectError() {

			Throwable exception =  assertThrows(ContractReportingGenericException.class,
					() -> csvDataInputBuilder.buildDataObject(Collections.EMPTY_LIST));

			assertEquals(exception.getMessage(), "No data found in input file or the data has been corrupted");
		}

		@Test
		public void testBuildDataObjectSuccess() {

				assertAll(
						() -> assertNotNull(csvDataInputBuilder.buildDataObject(buildDataObject())),
						() -> assertEquals(((List<CsvContractDataDto>)csvDataInputBuilder.buildDataObject(buildDataObject())).size(), 5),
						() -> assertEquals(((List<CsvContractDataDto>)csvDataInputBuilder.buildDataObject(buildDataObject())).stream().findFirst().get().getCustomerId(), 2343225));

		}

		private List<List<String>> buildDataObject () {

			return Arrays.asList(
					Arrays.asList("2343225", "2345", "us_east", "RedTeam", "ProjectApple", "3445s"),
					Arrays.asList("1223456", "2345", "us_west", "BlueTeam", "ProjectBanana", "2211s"),
					Arrays.asList("3244332", "2346", "eu_west", "YellowTeam3", "ProjectCarrot", "4322s"),
					Arrays.asList("1233456", "2345", "us_west", "BlueTeam", "ProjectDate", "2221s"),
					Arrays.asList("3244132", "2346", "eu_west", "YellowTeam3", "ProjectEgg", "4122s"));
		}
}
