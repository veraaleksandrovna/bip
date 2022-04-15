package com.example.bip.domain;

import javax.persistence.*;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderID", nullable = false)
    private Long orderID;

    @Column (name = "totalCost", nullable = false)
    private Integer totalCost;

    @ManyToOne
    @JoinColumn(name = "flowerOrderFK", referencedColumnName = "flowerID", nullable = false)
    private Flower flower;

    @ManyToOne
    @JoinColumn(name= "emplOrderFK", referencedColumnName = "employeeID", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "clientOrderFK", referencedColumnName = "clientID", nullable = false)
    private Client client;

    public Order() {
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
