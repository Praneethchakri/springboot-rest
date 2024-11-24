package com.employee.data.service.employementExchange.mapper;

import com.employee.data.service.employementExchange.dto.EmployeeDTO;
import com.employee.data.service.employementExchange.entityModel.Employee;

public class EmployeeMapperUtility {
        public  static Employee convertToUser(EmployeeDTO userDTO){
            return  new Employee(userDTO.getId(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getEmail(),userDTO.getDeportmentCode());
        }

        public static EmployeeDTO convertToUserDTO(Employee user){
            return new EmployeeDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getDeportmentCode());
        }
}
