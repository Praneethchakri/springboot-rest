package com.hibernate.learning.Advance.Hiberate.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employeeData")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_SEQ")
    @SequenceGenerator(name = "student_SEQ",sequenceName = "student_SEQ",allocationSize = 1)
    private int employeeId;
    @Column(name = "employee_firstName")
    private String empFirstName;

    @Column(name = "employee_lastName")
    private String empLastName;

    @Column(name = "employee_mailId")
    private String emailId;

    public Employee(String empFirstName, String empLastName, String emailId) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.emailId = emailId;
    }

    public Employee() {
    }
    @ElementCollection
    @JoinTable(name = "socialNetworkData",joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "socialNetworkdetails")
    private Set<String> socialNetwork = new HashSet<String>();

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<String> getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(Set<String> socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
