package com.spring.erudio.api_gateway.services;

import com.spring.erudio.api_gateway.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final Logger logger = LoggerFactory.getLogger(AddressService.class.getName());

    public Address callMicroCep(String postal_code) {
        logger.info("Request to microCRP");

        return new Address();
    }
}
