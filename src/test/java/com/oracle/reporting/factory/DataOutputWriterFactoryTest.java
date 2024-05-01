package com.oracle.reporting.factory;

import com.oracle.reporting.factory.impl.DataOutputWriterFactory;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import com.oracle.reporting.util.constant.FactoryEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DataOutputWriterFactoryTest {

    private static DataFactory dataFactory = null;

    @BeforeAll
    public static void setup() {
        dataFactory = new DataOutputWriterFactory();
    }

    @Test
    public void testGetInstance() {

        assertAll(
                () -> assertTrue(dataFactory.getInstance(FactoryEnum.DATA_OUTPUT_WRITER_REPORTING) instanceof ReportingDataOutputWriter),
                () -> assertNull(dataFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV))
        );
    }
}
