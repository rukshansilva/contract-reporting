package com.oracle.reporting.factory;

import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import com.oracle.reporting.util.constant.FactoryEnum;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DataOutputWriterFactoryTest {

    @Test
    public void testGetInstance() {

        assertAll(
                () -> assertTrue(DataOutputWriterFactory.getInstance(FactoryEnum.DATA_OUTPUT_WRITER_REPORTING) instanceof ReportingDataOutputWriter),
                () -> assertNull(DataOutputWriterFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV))
        );
    }
}
