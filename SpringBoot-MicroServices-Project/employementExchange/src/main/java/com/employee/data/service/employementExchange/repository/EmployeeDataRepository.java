package com.employee.data.service.employementExchange.repository;

import com.employee.data.service.employementExchange.entityModel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeDataRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeByEmail(String emailId);

}
