package nl.kolvoort.simplecalculator.service;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class SimpleCalculatorServiceImplTest {

    @Mock
    private SimpleCalculator simpleCalculatorMock;

    @InjectMocks
    private SimpleCalculatorServiceImpl simpleCalculaterService;

    @Test
    public void doCalculateShouldCallAdd(){

        // Arrange
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = Constants.ADD;
        double expected = 7.0;

        when(simpleCalculatorMock.add(leftOperand,rightOperand)).thenReturn(expected);

        // Act
        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.ADD);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).add(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallSubtract(){

        // Arrange
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = Constants.SUBTRACT;
        double expected = 3.0;

        when(simpleCalculatorMock.subtract(leftOperand,rightOperand)).thenReturn(expected);

        // Act
        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.SUBTRACT);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).subtract(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallMultiply(){

        // Arrange
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = Constants.MULTIPLY;
        double expected = 10.0;

        when(simpleCalculatorMock.multiply(leftOperand,rightOperand)).thenReturn(expected);

        // Act
        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.MULTIPLY);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).multiply(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldCallDivide(){

        // Arrange
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = Constants.DIVIDE;
        double expected = 2.5;

        when(simpleCalculatorMock.divide(leftOperand,rightOperand)).thenReturn(expected);

        // Act
        double result = simpleCalculaterService.doCalculation(leftOperand, rightOperand, Constants.DIVIDE);

        // Assert
        assertEquals(expected, result);
        verify(simpleCalculatorMock, times(1)).divide(leftOperand, rightOperand);
    }

    @Test
    public void doCalculateShouldThrowIllegalArgumentException(){

        // Arrange
        int leftOperand = 5;
        int rightOperand = 2;
        String operator = "^";  // unsupported operator

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> simpleCalculaterService.doCalculation(leftOperand, rightOperand, operator));
    }
}
