package com.employee.data.service.employementExchange.mapper;

import com.employee.data.service.employementExchange.dto.UserDTO;
import com.employee.data.service.employementExchange.entityModel.User;

public class UserMapperUtility {
        public  static User convertToUser(UserDTO userDTO){
            return  new User(userDTO.getId(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getEmail());
        }

        public static UserDTO convertToUserDTO(User user){
            return new UserDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
        }
}
