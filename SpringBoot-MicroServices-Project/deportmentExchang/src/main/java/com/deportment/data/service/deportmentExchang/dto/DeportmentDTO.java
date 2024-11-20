package com.deportment.data.service.deportmentExchang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DeportmentDTO {
    private  Long id;
    private String deportmentName;
    private String deportmentDescription;
    private String deportmentCode;

    public DeportmentDTO() {
    }

    public DeportmentDTO(Long id, String deportmentName, String deportmentDescription, String deportmentCode) {
        this.id = id;
        this.deportmentName = deportmentName;
        this.deportmentDescription = deportmentDescription;
        this.deportmentCode = deportmentCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeportmentName() {
        return deportmentName;
    }

    public void setDeportmentName(String deportmentName) {
        this.deportmentName = deportmentName;
    }

    public String getDeportmentDescription() {
        return deportmentDescription;
    }

    public void setDeportmentDescription(String deportmentDescription) {
        this.deportmentDescription = deportmentDescription;
    }

    public String getDeportmentCode() {
        return deportmentCode;
    }

    public void setDeportmentCode(String deportmentCode) {
        this.deportmentCode = deportmentCode;
    }

    @Override
    public String toString() {
        return "DeportmentDTO{" +
                "id=" + id +
                ", deportmentName='" + deportmentName + '\'' +
                ", deportmentDescription='" + deportmentDescription + '\'' +
                ", deportmentCode='" + deportmentCode + '\'' +
                '}';
    }
}
