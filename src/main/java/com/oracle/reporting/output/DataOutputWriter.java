package com.oracle.reporting.output;

/**
 * Input Data Writer Interface
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataOutputWriter <I, R> {

    R processOutput(I input);
}
