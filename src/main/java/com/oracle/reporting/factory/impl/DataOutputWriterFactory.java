package com.oracle.reporting.factory.impl;

import com.oracle.reporting.factory.DataFactory;
import com.oracle.reporting.output.DataOutputWriter;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Output Writer Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class DataOutputWriterFactory implements DataFactory<DataOutputWriter> {

    /**
     * @return an Instance of DataOutputWriter
     */
    @Override
    public DataOutputWriter getInstance(FactoryEnum instance) {

        if(FactoryEnum.DATA_OUTPUT_WRITER_REPORTING.equals(instance)) {
            return new ReportingDataOutputWriter();
        }

        return null;
    }
}
