package nl.kolvoort.simplecalculator.service;

import nl.kolvoort.simplecalculator.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleCalculatorServiceImplTest {

    @Mock
    private SimpleCalculator simpleCalculatorMock;

    @InjectMocks
    private SimpleCalculatorServiceImpl simpleCalculaterService;

    @Test
    public void doCalculateShouldCallAdd(){
        int leftOperand = 5;
        int rightOperand = 2;
        double expected = 7.0;

        when(simpleCalculatorMock.add(leftOperand,rightOperand)).thenReturn(expected);

        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.ADD);

        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).add(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallSubtract(){
        int leftOperand = 5;
        int rightOperand = 2;
        double expected = 3.0;

        when(simpleCalculatorMock.subtract(leftOperand,rightOperand)).thenReturn(expected);

        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.SUBTRACT);

        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).subtract(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallMultiply(){
        int leftOperand = 5;
        int rightOperand = 2;
        double expected = 10.0;

        when(simpleCalculatorMock.multiply(leftOperand,rightOperand)).thenReturn(expected);

        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.MULTIPLY);

        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).multiply(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallDivide(){
        int leftOperand = 5;
        int rightOperand = 2;
        double expected = 2.5;

        when(simpleCalculatorMock.divide(leftOperand,rightOperand)).thenReturn(expected);

        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.DIVIDE);

        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).divide(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldThrowIllegalArgumentException(){
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = "unsupported operator";

        assertThrows(IllegalArgumentException.class, () -> simpleCalculaterService.doCalculation(leftOperand, rightOperand, operator));
    }
}
