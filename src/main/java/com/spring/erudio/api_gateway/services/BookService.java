package com.spring.erudio.api_gateway.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.spring.erudio.api_gateway.controllers.BookController;
import com.spring.erudio.api_gateway.data.vo.v1.BookVO;
import com.spring.erudio.api_gateway.exceptions.RequiredObjectIsNullException;
import com.spring.erudio.api_gateway.exceptions.ResourceNotFoundException;
import com.spring.erudio.api_gateway.mapper.DozerMapper;
import com.spring.erudio.api_gateway.model.Book;
import com.spring.erudio.api_gateway.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private final Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository repository;

    public List<BookVO> findAll() {
        logger.info("Finding all books...");

        var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
        books.stream().forEach(b -> b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
        return books;
    }

    public BookVO findById(Long id) {
        logger.info("Finding one book...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        var vo = DozerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO book) {
        if (book == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one book...");

        var entity = DozerMapper.parseObject(book, Book.class);
        var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BookVO update(BookVO book) {
        if (book == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one book...");

        var entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setCategory(book.getCategory());
        entity.setNumberOfPages(book.getNumberOfPages());

        var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one book...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records for this id!"));

        repository.delete(entity);
    }
}
