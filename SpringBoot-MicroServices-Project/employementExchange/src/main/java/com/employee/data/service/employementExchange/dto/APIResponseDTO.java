package com.employee.data.service.employementExchange.dto;

public class APIResponseDTO {
    private EmployeeDTO employeeDTO;
    private DeportmentDTO deportmentDTO;

    public APIResponseDTO(EmployeeDTO employeeDTO, DeportmentDTO deportmentDTO) {
        this.employeeDTO = employeeDTO;
        this.deportmentDTO = deportmentDTO;
    }

    public APIResponseDTO() {
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public DeportmentDTO getDeportmentDTO() {
        return deportmentDTO;
    }

    public void setDeportmentDTO(DeportmentDTO deportmentDTO) {
        this.deportmentDTO = deportmentDTO;
    }
}
