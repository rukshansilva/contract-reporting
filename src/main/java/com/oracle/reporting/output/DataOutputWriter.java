package com.oracle.reporting.output;

/**
 * Input Data Writer Interface
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataOutputWriter<I, R> {

    /**
     * Process the Output
     */
    R processOutput(I input);
}
