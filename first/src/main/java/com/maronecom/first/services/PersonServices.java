package com.maronecom.first.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maronecom.first.data.vo.v1.PersonVO;
import com.maronecom.first.exceptions.ResourseNotFoundException;
import com.maronecom.first.mapper.DozerMapper;
import com.maronecom.first.models.Person;
import com.maronecom.first.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
        logger.info("Finding all people");
        return DozerMapper.parseObject(repository.findAll(), PersonVO.class) ;
    }

    public PersonVO findById(Long id){
        logger.info("Looking for one person");
        var entity = repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO personVO){
        logger.info("Updating person");
        var entity = repository.findById(personVO.getId()).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setGender(personVO.getGender());
        entity.setAddress(personVO.getAddress());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting person");
        var entity = repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
