package com.employee.data.service.employementExchange.services;

import com.employee.data.service.employementExchange.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeDataService {
    EmployeeDTO createUser(EmployeeDTO u);
    EmployeeDTO updateUser(Long id,EmployeeDTO u);
    Optional<EmployeeDTO> findUserById(Long id);

    List<EmployeeDTO> findAllUser();

    void deleteUserById(Long id);


}
