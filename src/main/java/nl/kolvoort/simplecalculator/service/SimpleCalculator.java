package nl.kolvoort.simplecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {

    public double add(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

    public double subtract(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }

    public double multiply(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
    }

    public double divide(int leftOperand, int rightOperand) {
        if (rightOperand == 0){
            throw new ArithmeticException("Can't divide by zero");
        }
        return (double) leftOperand / (double) rightOperand;

    }

}
