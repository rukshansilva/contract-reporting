package com.oracle.reporting.factory;

import com.oracle.reporting.input.DataInputReader;
import com.oracle.reporting.input.impl.CsvDataInputReaderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Input Reader Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class DataInputReaderFactory {

    /**
     * @return an Instance of DataInputReader
     */
    public static DataInputReader getInstance(FactoryEnum instance) {

        if(FactoryEnum.DATA_INPUT_READER_CSV.equals(instance)) {
            return new CsvDataInputReaderImpl();
        }

        return null;
    }
}
