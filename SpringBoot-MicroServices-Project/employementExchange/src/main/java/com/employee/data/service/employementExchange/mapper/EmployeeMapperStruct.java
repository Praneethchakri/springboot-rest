package com.employee.data.service.employementExchange.mapper;

import com.employee.data.service.employementExchange.dto.EmployeeDTO;
import com.employee.data.service.employementExchange.entityModel.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapperStruct {
    /*
    IF the Model classes nameing conventions are different in each class we can use the explict mapper on each method as below
    @Mapping(source = "email",target = "emailId")
    Here in the above example the User class has the email field , but while mapping the target class UserDTO has differetn name ,to mapp this we use here the
    @Mapping and map the fields.
     */

    EmployeeMapperStruct USER_MAPPER_STRUCT  = Mappers.getMapper(EmployeeMapperStruct.class);

    EmployeeDTO mapToUserDTO(Employee employee);
    Employee maptTOUSer(EmployeeDTO userDTO);

}
