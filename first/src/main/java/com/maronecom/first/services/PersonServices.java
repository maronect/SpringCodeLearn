package com.maronecom.first.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.maronecom.first.models.Person;

@Service
public class PersonServices {
    private final AtomicLong cont = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        logger.info("Finding all people");
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    private Person mockPerson(int i) { 
        Person person = new Person();
        person.setId(cont.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address " + i);
        person.setGender("Male");


        return person;
    }

}
