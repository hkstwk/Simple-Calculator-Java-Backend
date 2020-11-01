package nl.kolvoort.simplecalculator.service;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculaterService {

    // fields
    private final SimpleCalculator simpleCalculator;

    // constructors
    @Autowired
    public SimpleCalculatorServiceImpl(SimpleCalculator simpleCalculator) {
        log.info("SimpleCalculatorController instantiated");
        this.simpleCalculator = simpleCalculator;
    }

    @Override
    public double doCalculation(int leftOperand, int rightOperand, String operator) {

        switch (operator) {
            case Constants.ADD:
                return simpleCalculator.add(leftOperand, rightOperand);
            case Constants.SUBTRACT:
                return simpleCalculator.subtract(leftOperand, rightOperand);
            case Constants.MULTIPLY:
                return simpleCalculator.multiply(leftOperand, rightOperand);
            case Constants.DIVIDE:
                return simpleCalculator.divide(leftOperand, rightOperand);
            default:
                throw new IllegalArgumentException("Operator not supported");
        }
    }


}
