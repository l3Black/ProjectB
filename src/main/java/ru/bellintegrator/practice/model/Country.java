package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQuery(name = Country.ALL, query = "SELECT c FROM Country c")
@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Country {

    public static final String ALL = "Country.All";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    @NotNull
    private Integer code;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank
    private String name;

    /**
     * Constructor for hibernate
     */
    public Country() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
