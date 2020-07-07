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

@NamedQuery(name = DocumentType.ALL, query = "SELECT dt FROM DocumentType dt")
@Entity
@Table(name = "document_type", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class DocumentType {

    public static final String ALL = "DocumentType.All";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    @NotNull
    private Integer code;

    @Column(name = "name", length = 200, nullable = false)
    @NotBlank
    private String name;

    /**
     * Constructor for hibernate
     */
    public DocumentType() {
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
