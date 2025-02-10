package com.spring.erudio.api_gateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 4351683558287206177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 250, nullable = false)
    private String title;
    @Column(name = "category", length = 80)
    private String category;
    @Column(name = "author", length = 100)
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "launch_date", length = 10, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(name = "number_of_pages")
    private Integer numberOfPages;
    @Column(name = "price", nullable = false)
    private Double price;

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

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
