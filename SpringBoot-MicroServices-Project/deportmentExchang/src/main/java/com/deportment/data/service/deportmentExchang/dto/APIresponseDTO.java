package com.deportment.data.service.deportmentExchang.dto;

import java.util.List;

public class APIresponseDTO {
    private DeportmentDTO deportmentDTO;
    private List<EmployeeDTO> employeeDTOList;

    public APIresponseDTO(DeportmentDTO deportmentDTO, List<EmployeeDTO> employeeDTOList) {
        this.deportmentDTO = deportmentDTO;
        this.employeeDTOList = employeeDTOList;
    }

    public APIresponseDTO() {
    }

    public DeportmentDTO getDeportmentDTO() {
        return deportmentDTO;
    }

    public void setDeportmentDTO(DeportmentDTO deportmentDTO) {
        this.deportmentDTO = deportmentDTO;
    }

    public List<EmployeeDTO> getEmployeeDTOList() {
        return employeeDTOList;
    }

    public void setEmployeeDTOList(List<EmployeeDTO> employeeDTOList) {
        this.employeeDTOList = employeeDTOList;
    }
}
