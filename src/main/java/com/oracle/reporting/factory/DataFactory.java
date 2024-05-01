package com.oracle.reporting.factory;

import com.oracle.reporting.util.constant.FactoryEnum;

/**
 * Data Factory interface
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataFactory<R>{

    /**
     * @return an Instance of R
     */
    R getInstance(FactoryEnum instance);
}
