package nl.kolvoort.simplecalculator.controller;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import nl.kolvoort.simplecalculator.dto.CalculationInput;
import nl.kolvoort.simplecalculator.dto.CalculationOutput;
import nl.kolvoort.simplecalculator.service.SimpleCalculaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class SimpleCalculatorController {

    // fields
    private final SimpleCalculaterService simpleCalculaterService;

    // constructor
    @Autowired
    public SimpleCalculatorController(SimpleCalculaterService simpleCalculaterService) {
        log.info("SimpleCalculatorService instantiated");
        this.simpleCalculaterService = simpleCalculaterService;
    }

    // private methods
    private String doCalculation(@NonNull CalculationInput calculationInput){
        String result;
        try {
            result = Double.toString(simpleCalculaterService.doCalculation(
                    calculationInput.getLeftOperand(),
                    calculationInput.getRightOperand(),
                    calculationInput.getOperator()));
        } catch (ArithmeticException | IllegalArgumentException e){
            log.debug("Exception caught! {}", e.toString());
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

    // end points
    @PostMapping("/single")
    @CrossOrigin("*")
    public CalculationOutput procesSingleCalculation(@RequestBody CalculationInput calculationInput) {

        log.info("processSingleCalculation called() with body {}", calculationInput);

        CalculationOutput calculationOutput = getCalculationOutput(calculationInput);

        log.debug("processSingleCalculation() - result of calculationInput is {}", calculationOutput);

        return calculationOutput;
    }

    @PostMapping("/multiple")
    @CrossOrigin("*")
    public List<CalculationOutput> procesMultipleCalculations(@RequestBody List<CalculationInput> calculationInputList) {
        log.info("processMultipleCalculation called() with body {}", calculationInputList);

        List<CalculationOutput> results = new ArrayList<>();

        for (CalculationInput calc : calculationInputList) {

            // Perform calculation for current input
            log.debug("CalculationInput done with input {}", calc);

            CalculationOutput calculationOutput = getCalculationOutput(calc);

            results.add(calculationOutput);
            log.debug("Result added to List<CalculationOutput>");

        }
        log.debug("processMultipleCalculations result set is {}", results);

        return results;

    }

}
