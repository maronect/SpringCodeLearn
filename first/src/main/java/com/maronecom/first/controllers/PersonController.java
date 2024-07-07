package com.maronecom.first.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;
import com.maronecom.first.exceptions.UnsupportedMathOperationExeption;
import com.maronecom.first.models.Person;
import com.maronecom.first.services.PersonServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final AtomicLong cont = new AtomicLong();

    @Autowired
    private PersonServices service = new PersonServices();
    //private PersonServices service = new PersonServices();


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
        @PathVariable(value = "id")String id
    ){
        return service.findById(id);
    }

    @RequestMapping(value = "/sqr/{id}", method = RequestMethod.GET)
    public Double sqrt(
        @PathVariable(value = "id")String id
    ) throws Exception{
        if (!isNumeric(id)) {
            throw new UnsupportedMathOperationExeption("Set a number type value!");
        }
        if (convertToDouble(id) < 0) {
            throw new UnsupportedMathOperationExeption("Only positive numbers ar allowed!");
        }
        return Math.sqrt(convertToDouble(id));
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

