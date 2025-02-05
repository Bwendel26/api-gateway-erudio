package com.spring.erudio.api_gateway.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 4351683558287206177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100,nullable = false)
    private String title;
    @Column(name = "category", length = 80,nullable = false)
    private String category;
    @Column(name = "author", length = 100,nullable = false)
    private String author;
    @Column(name = "number_of_pages", length = 20,nullable = false)
    private Integer numberOfPages;
    @Column(name = "language", length = 30,nullable = false)
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(category, book.category) && Objects.equals(author, book.author) && Objects.equals(numberOfPages, book.numberOfPages) && Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, author, numberOfPages, language);
    }
}
