package com.employee.data.service.employementExchange.dto;

import java.util.Objects;

public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String deportmentCode;

    public EmployeeDTO(Long id, String firstName, String lastName, String email, String deportmentCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deportmentCode = deportmentCode;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDTO that = (EmployeeDTO) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        return Objects.equals(deportmentCode, that.deportmentCode);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (deportmentCode != null ? deportmentCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", deportmentCode='" + deportmentCode + '\'' +
                '}';
    }
}
