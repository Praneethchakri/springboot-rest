package com.employee.data.service.employementExchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    private String name;
    private String fieldName;
    private Long fieldValue;

    public EmployeeNotFoundException(String name, String fieldName, Long fieldValue) {
      super(String.format("%s Not Found with %s : '%s'",name,fieldName,fieldValue));
      this.name = name;
      this.fieldName=fieldName;
      this.fieldValue=fieldValue;
    }

    public EmployeeNotFoundException() {
    }
}
