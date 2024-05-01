package com.oracle.reporting.factory;

import com.oracle.reporting.output.DataOutputWriter;
import com.oracle.reporting.output.impl.ReportingDataOutputWriter;
import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Output Writer Factory
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class DataOutputWriterFactory {

    /**
     * @return an Instance of DataOutputWriter
     */
    public static DataOutputWriter getInstance(FactoryEnum instance) {

        if(FactoryEnum.DATA_OUTPUT_WRITER_REPORTING.equals(instance)) {
            return new ReportingDataOutputWriter();
        }

        return null;
    }
}
