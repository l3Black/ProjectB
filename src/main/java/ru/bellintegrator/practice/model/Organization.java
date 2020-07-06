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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "organization",
        indexes = {
                @Index(name = "IX_org_name", columnList = "name", unique = false),
                @Index(name = "IX_org_address", columnList = "address_id", unique = false),
                @Index(name = "UX_org_inn", columnList = "inn", unique = true)
        },
        uniqueConstraints = @UniqueConstraint(columnNames = "inn")
)
public class Organization {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "inn", nullable = false)
    private Long inn;

    @Column(name = "kpp", nullable = false)
    private Integer kpp;

    @Column(name = "phone", nullable = true)
    @Length(min = 10, max = 20)
    @NotBlank
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    /**
     * Constructor for hibernate
     */
    public Organization() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
