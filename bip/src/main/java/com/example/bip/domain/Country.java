package com.example.bip.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "countryID", nullable = false)
    private Long countryID;

    @Column (name = "countryName", nullable = false)
    private String countryName;

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private Set<Supplier> supplier;

    public Country(){}

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.supplier = supplier;
    }
}
