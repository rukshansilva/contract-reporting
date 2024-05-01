package com.oracle.reporting.factory;

import com.oracle.reporting.factory.impl.DataInputReaderFactory;
import com.oracle.reporting.input.impl.CsvDataInputReaderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DataInputReaderFactoryTest {

    private static DataFactory dataFactory = null;

    @BeforeAll
    public static void setup() {
        dataFactory = new DataInputReaderFactory();
    }

    @Test
    public void testGetInstance() {

        assertAll(
                () -> assertTrue(dataFactory.getInstance(FactoryEnum.DATA_INPUT_READER_CSV) instanceof CsvDataInputReaderImpl),
                () -> assertNull(dataFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV))
        );
    }
}
