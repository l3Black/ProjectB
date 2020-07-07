package ru.bellintegrator.practice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "office",
        indexes = {
                @Index(name = "IX_office_name", columnList = "name", unique = false),
                @Index(name = "IX_office_phone", columnList = "phone", unique = false),
                @Index(name = "IX_office_address", columnList = "address_id", unique = false)
        }
)
public class Office {
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

    @Column(name = "phone", nullable = true)
    @Length(min = 10, max = 20)
    @NotBlank
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * Organization which owns an office
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    private Organization organization;

    /**
     * Constructor for hibernate
     */
    public Office() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
