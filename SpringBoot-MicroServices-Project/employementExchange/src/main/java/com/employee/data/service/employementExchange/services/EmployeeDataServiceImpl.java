package com.employee.data.service.employementExchange.services;

import com.employee.data.service.employementExchange.dto.EmployeeDTO;
import com.employee.data.service.employementExchange.entityModel.Employee;
import com.employee.data.service.employementExchange.exception.EmailAlreadyExistException;
import com.employee.data.service.employementExchange.exception.EmployeeNotFoundException;
import com.employee.data.service.employementExchange.mapper.EmployeeMapperStruct;
import com.employee.data.service.employementExchange.mapper.UserMapperUtility;
import com.employee.data.service.employementExchange.repository.EmployeeDataRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeDataServiceImpl implements  EmployeeDataService{
    private EmployeeDataRepository employeeDataRepository;

//    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO createUser(EmployeeDTO userDTO) {



        Optional<Employee> employeeByMaiId = employeeDataRepository.findEmployeeByEmail(userDTO.getEmail());
        if(employeeByMaiId.isPresent()){
            throw  new EmailAlreadyExistException("Email Already Used/Registered !! Please Try With Another mail ID");
        }
//        User userObejct = UserMapperUtility.convertToUser(userDTO);
        /**
         * USing ModelMapper Utility we are mapping the data between the entity/JPA class and DTO class
         */
//        User userObejct = modelMapper.map(userDTO,User.class);
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
        Employee userObejct = EmployeeMapperStruct.USER_MAPPER_STRUCT.maptTOUSer(userDTO);

        Employee savedObject = employeeDataRepository.save(userObejct);

//         UserDTO savedUserDTO = UserMapperUtility.convertToUserDTO(savedObject); -->Using Utitlity Method with stream and conversions
//        UserDTO savedUserDTO = modelMapper.map(savedObject, UserDTO.class); --> Using ModelMapper
        EmployeeDTO savedUserDTO = EmployeeMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(savedObject); // Using MapStruct
         return  savedUserDTO;
    }
    @Transactional //Transactions: Updates require a transaction. Annotate your method or class with @Transactional.
    @Override
    public EmployeeDTO updateUser(Long id,EmployeeDTO u) {
        Employee entityRequestObject = new Employee(
                u.getId(),
                u.getFirstName(),
                u.getLastName(),
                u.getEmail()
        );

        Employee user=  employeeDataRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee","id",u.getId()));
        System.out.println("Data "+user);
            user.setEmail(u.getEmail());
            user.setFirstName(u.getFirstName());
            user.setLastName(u.getLastName());
//            UserDTO updatedUserDTO = UserMapperUtility.convertToUserDTO(user); --> utlity MEthod
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
            EmployeeDTO updatedEmployeeDTO = EmployeeMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(user);
        return  updatedEmployeeDTO;
    }

    @Override
    public Optional<EmployeeDTO> findUserById(Long id) {

        Employee returnObejct=  employeeDataRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee","id",id));
//        Employee user = retunObejct.get();
//        UserDTO userDTO = UserMapperUtility.convertToUserDTO(user);
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
        EmployeeDTO userDTO = EmployeeMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(returnObejct);
        return Optional.of(userDTO);
    }

    @Override
    public List<EmployeeDTO> findAllUser() {
        List<Employee> returnListObejct=  employeeDataRepository.findAll();
        return converListData(returnListObejct);


    }

    @Override
    public void deleteUserById(Long id) {
        Employee u = employeeDataRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee","id",id));
            employeeDataRepository.deleteById(id);
    }

    /**
     * Using Collection & steams
     * @param inputList
     * @return
     */

    public static List<EmployeeDTO> converListData(List<Employee> inputList){
        List<EmployeeDTO> result = inputList.stream()
                .map(UserMapperUtility::convertToUserDTO)
                .collect(Collectors.toList());
        return  result;

    }

}
