package com.spring.erudio.api_gateway.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "title", "category", "author", "launchDate", "numberOfPages", "price"})
public class BookVO extends RepresentationModel<BookVO>  implements Serializable {

    @Serial
    private static final long serialVersionUID = -3707232934093644561L;

    @JsonProperty("id")
    private Long key;
    private String title;
    private String category;
    private String author;
    private Date launchDate;
    private Integer numberOfPages;
    private Double price;

    public BookVO() {}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookVO bookVO = (BookVO) o;
        return Objects.equals(key, bookVO.key) && Objects.equals(title, bookVO.title) && Objects.equals(category, bookVO.category) && Objects.equals(author, bookVO.author) && Objects.equals(launchDate, bookVO.launchDate) && Objects.equals(numberOfPages, bookVO.numberOfPages) && Objects.equals(price, bookVO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, title, category, author, launchDate, numberOfPages, price);
    }
}
