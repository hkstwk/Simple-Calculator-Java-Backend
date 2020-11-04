package nl.kolvoort.simplecalculator.controller;

import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.dto.CalculationInput;
import nl.kolvoort.simplecalculator.dto.CalculationOutput;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Slf4j
public class SimpleCalculatorControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private SimpleCalculatorController simpleCalculatorController;

    public SimpleCalculatorControllerTest(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(simpleCalculatorController)
                .build();
        log.info("MockMVC created");
    }

    @Test
    public void singleAddShouldReturnPositiveResultInJsonFormat() throws Exception{

        CalculationInput calculationInput = new CalculationInput();
        calculationInput.setLeftOperand(2);
        calculationInput.setLeftOperand(3);
        calculationInput.setOperator("-");

        CalculationOutput calculationOutput = new CalculationOutput(
                calculationInput.getLeftOperand(),
                calculationInput.getRightOperand(),
                calculationInput.getOperator(),
                null);

        mockMvc.perform(post("/single")
                .content("{\"leftOperand\": 99,\"rightOperand\": 0,\"operator\":\"/\" }")

        );
    }
}
