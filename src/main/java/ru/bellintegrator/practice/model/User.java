package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user",
        indexes = {
                @Index(name = "", columnList = "first_name", unique = false),
                @Index(name = "", columnList = "middle_name", unique = false),
                @Index(name = "", columnList = "last_name", unique = false),
                @Index(name = "", columnList = "position", unique = false),
                @Index(name = "", columnList = "office", unique = false),
                @Index(name = "", columnList = "doc_number", unique = true),
                @Index(name = "", columnList = "country_id", unique = false)
        }
)
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "first_name", length = 50, nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "middle_name", length = 50, nullable = true)
    @NotBlank
    private String middleName;

    @Column(name = "last_name", length = 50, nullable = true)
    @NotBlank
    private String lastName;

    @Column(name = "position", length = 100, nullable = false)
    @NotBlank
    private String position;

    @Column(name = "phone", nullable = true)
    @Length(min = 10, max = 20)
    @NotBlank
    private String phone;

    @Column(name = "is_identified", nullable = false)
    private Boolean isIdentified;

    @OneToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country citizenship;

    @OneToOne
    @JoinColumn(name = "doc_number")
    private Document document;

    /**
     * Office in which an user works
     */
    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Country getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Country citizenship) {
        this.citizenship = citizenship;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
