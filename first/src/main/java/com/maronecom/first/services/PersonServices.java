package com.maronecom.first.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maronecom.first.exceptions.ResourseNotFoundException;
import com.maronecom.first.models.Person;
import com.maronecom.first.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all people");
        return repository.findAll();
    }

    public Person findById(Long id){
        
        logger.info("Looking for one person");



        return repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));

    }

    public Person create(Person person){
        logger.info("Creating person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating person");
        var entity = repository.findById(person.getId()).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting person");
        var entity = repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
