package com.employee.data.service.employementExchange.services;

import com.employee.data.service.employementExchange.dto.DeportmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPORTMENT-EXCHANGE-SERVICE")
public interface ApiDptClient {
    @GetMapping("depormentService/{deportment-code}")
    public ResponseEntity<DeportmentDTO> getDeportmentById(@PathVariable(name="deportment-code") String deportmentCode);
}
