package nl.kolvoort.simplecalculator.dto;

import lombok.Data;

public @Data
class CalculationInput {
    private int leftOperand;
    private int rightOperand;
    private String operator;
}
