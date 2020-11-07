package nl.kolvoort.simplecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class CalculationOutput {

    private int leftOperand;
    private int rightOperand;
    private String operator;

    // Result as string in order to also return exceptions in resultset.
    // Given correct input normally double would be returned
    private String result;
}
