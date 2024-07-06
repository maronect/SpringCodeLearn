package com.maronecom.first.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maronecom.first.exceptions.UnsupportedMathOperationExeption;
import com.maronecom.first.models.HelloSpring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
    private final AtomicLong cont = new AtomicLong();

    @RequestMapping(value = "/sum/{firstNum}/{secondNum}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "firstNum")String firstNum,
        @PathVariable(value = "secondNum")String secondNum
        
    ) throws Exception{
        if (!isNumeric(firstNum) || !isNumeric(secondNum) ) {
            throw new UnsupportedMathOperationExeption("Set a number type value!");
        }
        return convertToDouble(firstNum) + convertToDouble(secondNum); 
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

