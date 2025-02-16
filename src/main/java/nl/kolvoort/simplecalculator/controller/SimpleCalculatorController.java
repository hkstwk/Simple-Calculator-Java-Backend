package nl.kolvoort.simplecalculator.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.dto.CalculationInput;
import nl.kolvoort.simplecalculator.dto.CalculationOutput;
import nl.kolvoort.simplecalculator.service.SimpleCalculaterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SimpleCalculatorController {
    private final SimpleCalculaterService simpleCalculaterService;

    private String doCalculation(@NonNull CalculationInput calculationInput){
        String result;
        try {
            result = Double.toString(simpleCalculaterService.doCalculation(
                    calculationInput.getLeftOperand(),
                    calculationInput.getRightOperand(),
                    calculationInput.getOperator()));
        } catch (ArithmeticException | IllegalArgumentException e){
            log.info("Exception caught! {}", e.toString());
            result = e.toString();
        }
        return result;
    }

    private CalculationOutput getCalculationOutput(@NonNull CalculationInput calculationInput){
        return new CalculationOutput(
                calculationInput.getLeftOperand(),
                calculationInput.getRightOperand(),
                calculationInput.getOperator(),
                doCalculation(calculationInput));
    }

    @PostMapping("/single")
    @CrossOrigin("*")
    public CalculationOutput procesSingleCalculation(@RequestBody CalculationInput calculationInput) {
        log.info("processSingleCalculation called() with body {}", calculationInput);
        return getCalculationOutput(calculationInput);
    }

    @PostMapping("/multiple")
    @CrossOrigin("*")
    public List<CalculationOutput> procesMultipleCalculations(@RequestBody List<CalculationInput> calculationInputList) {
        log.info("processMultipleCalculation called() with body {}", calculationInputList);
        return calculationInputList.stream()
                .map(this::getCalculationOutput)
                .toList();
    }

}
