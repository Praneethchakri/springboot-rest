package com.employee.data.service.employementExchange.entityModel;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    private Long id;
    private String lastName;
    private String firstName;
    private String address;

    public Employee(Long id, String lastName, String firstName, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
