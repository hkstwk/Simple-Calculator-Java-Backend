package nl.kolvoort.simplecalculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SimpleCalculatorServiceImpl implements SimpleCalculaterService {

    private final SimpleCalculator simpleCalculator;

    @Override
    public double doCalculation(int leftOperand, int rightOperand, String operator) {

        return switch (operator) {
            case Constants.ADD -> simpleCalculator.add(leftOperand, rightOperand);
            case Constants.SUBTRACT -> simpleCalculator.subtract(leftOperand, rightOperand);
            case Constants.MULTIPLY -> simpleCalculator.multiply(leftOperand, rightOperand);
            case Constants.DIVIDE -> simpleCalculator.divide(leftOperand, rightOperand);
            default -> throw new IllegalArgumentException("Operator not supported");
        };
    }

}
