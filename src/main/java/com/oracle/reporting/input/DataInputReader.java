package com.oracle.contractportfolio.input;

public interface DataInputReader <Input, Output> {

    Output processInput(Input input);
}
