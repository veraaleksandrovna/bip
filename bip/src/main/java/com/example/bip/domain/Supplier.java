package com.example.bip.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "supplierID",nullable = false)
    private Long supplierID;

    @Column (name = "supplierName")
    private String supplierName;

    @ManyToOne
    @JoinColumn(name="suppliercountryFK", referencedColumnName = "countryID", nullable=false)
    private Country country;

    @OneToMany(mappedBy="supplier", cascade = CascadeType.ALL)
    private Set<Flower> flower;

    public Supplier() {}

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Flower> getFlower() {
        return flower;
    }

    public void setFlower(Set<Flower> flower) {
        this.flower = flower;
    }
}
