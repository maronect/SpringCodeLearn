package com.maronecom.first.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.maronecom.first.models.Person;

@Service
public class PersonServices {
    private final AtomicLong cont = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        
        logger.info("Looking for one person");

        Person person = new Person();
        person.setId(cont.incrementAndGet());
        person.setFirstName("Marone");
        person.setLastName("Taques");
        person.setGender("Male");
        person.setAddress("Brazil - Pernambuco - Recife");


        return person;

    }


}
