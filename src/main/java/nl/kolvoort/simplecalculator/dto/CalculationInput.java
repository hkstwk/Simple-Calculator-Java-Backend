package nl.kolvoort.simplecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationInput {
    private int leftOperand;
    private int rightOperand;
    private String operator;

}
