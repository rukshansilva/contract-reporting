package com.oracle.contractportfolio.output;

public interface DataOutputWriter <Input, Output> {

    Output processOutput(Input input);
}
