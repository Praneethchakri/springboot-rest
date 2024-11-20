package com.employee.data.service.employementExchange.services;

import com.employee.data.service.employementExchange.dto.UserDTO;
import com.employee.data.service.employementExchange.mapper.UserMapperStruct;
import com.employee.data.service.employementExchange.mapper.UserMapperUtility;
import com.employee.data.service.employementExchange.entityModel.User;
import com.employee.data.service.employementExchange.repository.UserDataRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDataServiceImpl implements  UserDataService{
    private UserDataRepository userDataRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

//        User userObejct = UserMapperUtility.convertToUser(userDTO);
        /**
         * USing ModelMapper Utility we are mapping the data between the entity/JPA class and DTO class
         */
//        User userObejct = modelMapper.map(userDTO,User.class);
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
        User userObejct = UserMapperStruct.USER_MAPPER_STRUCT.maptTOUSer(userDTO);
         User savedObject = userDataRepository.save(userObejct);

//         UserDTO savedUserDTO = UserMapperUtility.convertToUserDTO(savedObject); -->Using Utitlity Method with stream and conversions
//        UserDTO savedUserDTO = modelMapper.map(savedObject, UserDTO.class); --> Using ModelMapper
        UserDTO savedUserDTO = UserMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(savedObject); // Using MapStruct
         return  savedUserDTO;
    }
    @Transactional //Transactions: Updates require a transaction. Annotate your method or class with @Transactional.
    @Override
    public UserDTO updateUser(Long id,UserDTO u) {
        User entityRequestObject = new User(
                u.getId(),
                u.getFirstName(),
                u.getLastName(),
                u.getEmail()
        );

        User user=  userDataRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found!!"));
        System.out.println("Data "+user);
            user.setEmail(u.getEmail());
            user.setFirstName(u.getFirstName());
            user.setLastName(u.getLastName());
//            UserDTO updatedUserDTO = UserMapperUtility.convertToUserDTO(user); --> utlity MEthod
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
            UserDTO updatedUserDTO = UserMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(user);
        return  updatedUserDTO;
    }

    @Override
    public Optional<UserDTO> findUserById(Long id) {

        Optional<User> retunObejct=  userDataRepository.findById(id);
        User user = retunObejct.get();
//        UserDTO userDTO = UserMapperUtility.convertToUserDTO(user);
        /**
         * USing MapStruct Utility we are mapping the data between the entity/JPA class and DTO class
         */
        UserDTO userDTO = UserMapperStruct.USER_MAPPER_STRUCT.mapToUserDTO(user);
    return Optional.of(userDTO);
    }

    @Override
    public List<UserDTO> findAllUser() {
        List<User> returnListObejct=  userDataRepository.findAll();
        return converListData(returnListObejct);


    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> u = userDataRepository.findById(id);

        if(u.isPresent()) {
            userDataRepository.deleteById(id);
        }else{
            System.out.println("No Data Found to Delete");
        }
    }

    /**
     * Using Collection & steams
     * @param inputList
     * @return
     */
    public static List<UserDTO> converListData(List<User> inputList){
        List<UserDTO> result = inputList.stream()
                .map(UserMapperUtility::convertToUserDTO)
                .collect(Collectors.toList());
        return  result;

    }

}
