package com.example.bip.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="clientID", nullable = false)
    private Long clientID;

    @Column(name = "clientSurname", nullable = false)
    private String clientSurname;

    @Column(name = "clientName",nullable = false)
    private String clientName;

    @Column(name="dateOfBirth", nullable = false)
    private Date dateOfBirth;

    public Client(){}

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
