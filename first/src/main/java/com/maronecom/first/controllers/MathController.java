package com.maronecom.first.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;
import com.maronecom.first.exceptions.UnsupportedMathOperationExeption;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
    private final AtomicLong cont = new AtomicLong();

    @RequestMapping(value = "/{operator}/{firstNum}/{secondNum}", method = RequestMethod.GET)
    public Double operation(
        @PathVariable(value = "operator")String operator,
        @PathVariable(value = "firstNum")String firstNum,
        @PathVariable(value = "secondNum")String secondNum
        
    ) throws Exception{
        if (!isNumeric(firstNum) || !isNumeric(secondNum) ) {
            throw new UnsupportedMathOperationExeption("Set a number type value!");
        }
        switch (operator) {
            case "sum":
                return convertToDouble(firstNum) + convertToDouble(secondNum); 
            case "sub":
                return convertToDouble(firstNum) - convertToDouble(secondNum); 
            case "mul":
                return convertToDouble(firstNum) * convertToDouble(secondNum); 
            case "div":
                if (secondNum == "0") {
                    throw new UnsupportedMathOperationExeption("Can not divide by zero!");
                }
                return convertToDouble(firstNum) / convertToDouble(secondNum); 
            case "ave":
                return (convertToDouble(firstNum) + convertToDouble(secondNum))/2; 
            default:
                throw new UnsupportedMathOperationExeption("Undefined operator!");
        }
    }

    @RequestMapping(value = "/sqr/{firstNum}", method = RequestMethod.GET)
    public Double sqrt(
        @PathVariable(value = "firstNum")String firstNum
    ) throws Exception{
        if (!isNumeric(firstNum)) {
            throw new UnsupportedMathOperationExeption("Set a number type value!");
        }
        if (convertToDouble(firstNum) < 0) {
            throw new UnsupportedMathOperationExeption("Only positive numbers ar allowed!");
        }
        return Math.sqrt(convertToDouble(firstNum));
    }

    private Double convertToDouble(String num) throws Exception {
        if (num == null) throw new Exception("a");          
        String generalNum = num.replaceAll(",", ".");
        if (isNumeric(num)) return Double.parseDouble(generalNum);
        return 0D;
    }

    private boolean isNumeric(String num) {
        if (num == null) return false;
        String generalNum = num.replaceAll(",", ".");
        return generalNum.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

