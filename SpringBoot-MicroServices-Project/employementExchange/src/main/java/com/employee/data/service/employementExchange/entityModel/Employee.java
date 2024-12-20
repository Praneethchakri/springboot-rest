package com.employee.data.service.employementExchange.entityModel;

import jakarta.persistence.*;


@Entity
@Table(name = "EmployeeUserData")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name",nullable = false)
    private String firstName;
    @Column(name="last_Name",nullable = false)
    private String lastName;
    @Column(name="email_Id",nullable = false)
    private String email;

    @Column(name="deportmentCode")
    private String deportmentCode;

    public Employee(Long id, String firstName, String lastName, String email,String deportmentCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deportmentCode = deportmentCode;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeportmentCode() {
        return deportmentCode;
    }

    public void setDeportmentCode(String deportmentCode) {
        this.deportmentCode = deportmentCode;
    }
}
