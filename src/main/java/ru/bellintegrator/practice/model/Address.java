package ru.bellintegrator.practice.model;

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

@Entity
@Table(name = "address",
        indexes = @Index(name = "IX_address_country", columnList = "country_id"))
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "region", length = 50, nullable = false)
    @NotBlank
    private String region;

    @Column(name = "city", length = 50, nullable = true)
    @NotBlank
    private String city;

    @Column(name = "town", length = 50, nullable = true)
    @NotBlank
    private String town;

    @Column(name = "zip_code", nullable = true)
    private Integer zipCode;

    @Column(name = "street", length = 100, nullable = true)
    @NotBlank
    private String street;

    /**
     * Home number including corps and building
     */
    @Column(name = "home_number", length = 30, nullable = true)
    @NotBlank
    private String homeNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    /**
     * Constructor for hibernate
     */
    public Address() {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
