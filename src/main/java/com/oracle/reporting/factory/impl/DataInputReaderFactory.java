package com.oracle.reporting.factory.impl;

import com.oracle.reporting.factory.DataFactory;
import com.oracle.reporting.input.DataInputReader;
import com.oracle.reporting.input.impl.CsvDataInputReaderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Input Reader Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class DataInputReaderFactory implements DataFactory<DataInputReader> {

    /**
     * @return an Instance of DataInputReader
     */
    @Override
    public DataInputReader getInstance(FactoryEnum instance) {

        if(FactoryEnum.DATA_INPUT_READER_CSV.equals(instance)) {
            return new CsvDataInputReaderImpl();
        }

        return null;
    }
}
