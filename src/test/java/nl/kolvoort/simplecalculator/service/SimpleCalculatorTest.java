package nl.kolvoort.simplecalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator = new SimpleCalculator();

    @Test
    public void addShoudReturnCorrectPositiveResult(){
        assertEquals(7.0,simpleCalculator.add(5, 2));
    }

    @Test
    public void subtractShouldReturnCorrectPositiveResult(){
        assertEquals(10,simpleCalculator.subtract(15, 5));
    }

    @Test
    public void subtractShouldReturnCorrectNegativeResult(){
        assertEquals(-5,simpleCalculator.subtract(15, 20));
    }

    @Test
    public void multiplyShouldReturnCorrectPositiveResult(){
        assertEquals(21,simpleCalculator.multiply(3, 7));
    }

    @Test
    public void divideShouldReturnCorrectFractionalPositiveResult(){
        assertEquals(1.5,simpleCalculator.divide(3, 2));
    }

    @Test
    public void divideShouldReturnCorrectNegativeResult(){
        assertEquals(-9,simpleCalculator.divide(18, -2));
    }

    @Test
    public void divideByZeroShouldThrowArithmaticException(){
        assertThrows(ArithmeticException.class, () -> simpleCalculator.divide(5, 0));
    }

}
