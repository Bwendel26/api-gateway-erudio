package com.spring.erudio.api_gateway.services;

import com.spring.erudio.api_gateway.model.Person;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person...");

        //Mocked Person
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Bruno");
        person.setLastName("Fernandes");
        person.setAddress("Brasília - DF");
        person.setGender("Male");
        return person;
    }
}
