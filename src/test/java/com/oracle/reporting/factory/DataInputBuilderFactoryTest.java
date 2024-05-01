package com.oracle.reporting.factory;

import com.oracle.reporting.input.impl.CsvDataInputBuilderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DataInputBuilderFactoryTest {

    @Test
    public void testGetInstance() {

        assertAll(
                () -> assertTrue(DataInputBuilderFactory.getInstance(FactoryEnum.DATA_INPUT_BUILDER_CSV) instanceof CsvDataInputBuilderImpl),
                () -> assertNull(DataInputBuilderFactory.getInstance(FactoryEnum.DATA_INPUT_READER_CSV))
        );
    }
}
