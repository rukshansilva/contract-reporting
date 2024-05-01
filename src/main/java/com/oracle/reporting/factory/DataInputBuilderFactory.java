package com.oracle.reporting.factory;

import com.oracle.reporting.input.DataInputBuilder;
import com.oracle.reporting.input.impl.CsvDataInputBuilderImpl;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Input Builder Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class DataInputBuilderFactory {

    /**
     * @return an Instance of DataInputBuilder
     */
    public static DataInputBuilder getInstance(FactoryEnum instance) {

        if(FactoryEnum.DATA_INPUT_BUILDER_CSV.equals(instance)) {
            return new CsvDataInputBuilderImpl();
        }

        return null;
    }
}
