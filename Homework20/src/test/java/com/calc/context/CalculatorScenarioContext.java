package com.calc.context;

import java.util.HashMap;
import java.util.Map;

public class CalculatorScenarioContext {

    private final Map<String,Double> calculatorResult = new HashMap<>();
    private Exception exception = new Exception();

    public void putVariable(String key, double value) {
        calculatorResult.put(key, value);
    }

    public double getVariable(String key) {
        return calculatorResult.get(key);
    }

    public void setException(Exception e) {
        this.exception = e;
    }

    public Exception getException() {
        return exception;
    }

}
