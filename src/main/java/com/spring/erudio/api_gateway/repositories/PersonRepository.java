package com.spring.erudio.api_gateway.repositories;

import com.spring.erudio.api_gateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
