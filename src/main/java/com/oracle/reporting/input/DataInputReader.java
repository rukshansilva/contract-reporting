package com.oracle.reporting.input;

/**
 * Input Data Reader Interface
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public interface DataInputReader <I, R> {

    R processInput(I input);
}
