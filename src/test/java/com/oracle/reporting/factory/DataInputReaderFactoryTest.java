package com.oracle.reporting.factory;

import com.oracle.reporting.input.impl.CsvDataInputReaderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DataInputReaderFactoryTest {

    @Test
    public void testGetInstance() {

        assertAll(
                () -> assertTrue(DataInputReaderFactory.getInstance(FactoryEnum.DATA_INPUT_READER_CSV) instanceof CsvDataInputReaderImpl),
                () -> assertNull(DataInputReaderFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV))
        );
    }
}
