package com.spring.erudio.api_gateway.repositories;

import com.spring.erudio.api_gateway.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
