package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8080",value = "EMPLOYEE-SERVICES")
public interface ApiClient {

    @GetMapping("/employee-Data/AllEmployee")
    List<EmployeeDTO> getAllExistingEmployee();

}
