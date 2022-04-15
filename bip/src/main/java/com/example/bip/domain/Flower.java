package com.example.bip.domain;

import javax.persistence.*;

@Entity
@Table(name="flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "flowerID", nullable = false)
    private Long flowerID;

    @Column(name = "flowerName", nullable = false)
    private String flowerName;

    @Column (name="description", nullable = false)
    private String description;

    @Column (name = "typeFlower", nullable = false)
    private String typeFlower;

    @Column (name = "cost", nullable = false)
    private Integer cost;

    @ManyToOne
    @JoinColumn (name = "flowersupplierID", referencedColumnName = "supplierID", nullable = false)
    private Supplier supplier;

    public Flower() {
    }

    public Long getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(Long flowerID) {
        this.flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeFlower() {
        return typeFlower;
    }

    public void setTypeFlower(String typeFlower) {
        this.typeFlower = typeFlower;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
