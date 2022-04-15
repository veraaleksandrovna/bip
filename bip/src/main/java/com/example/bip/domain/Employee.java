package com.example.bip.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name  = "employeeID", nullable = false)
    private Long employeeID;

    @Column (name = "employeeName",nullable = false)
    private String employeeName;

    @Column (name="employeeSurname", nullable = false)
    private String employeeSurname;

    @Column (name = "jobTitle",nullable = false)
    private String jobTitle;

    @Column (name = "office", nullable = false)
    private String office;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "empluserID", referencedColumnName = "userID")
    private User user;

    public Employee(){}

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
