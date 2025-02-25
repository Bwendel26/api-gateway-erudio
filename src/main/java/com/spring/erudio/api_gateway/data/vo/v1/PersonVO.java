package com.spring.erudio.api_gateway.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "firstName", "lastName", "cep", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1608673333697175331L;

    @JsonProperty("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String cep;
    private String gender;

    public PersonVO() {}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVo = (PersonVO) o;
        return Objects.equals(key, personVo.key) && Objects.equals(firstName, personVo.firstName) && Objects.equals(lastName, personVo.lastName) && Objects.equals(cep, personVo.cep) && Objects.equals(gender, personVo.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, cep, gender);
    }
}
