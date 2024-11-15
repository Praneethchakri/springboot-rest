package com.employee.data.service.employementExchange.services;

import com.employee.data.service.employementExchange.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDataService {
    UserDTO createUser(UserDTO u);
    UserDTO updateUser(Long id,UserDTO u);
    Optional<UserDTO> findUserById(Long id);

    List<UserDTO> findAllUser();

    void deleteUserById(Long id);


}
