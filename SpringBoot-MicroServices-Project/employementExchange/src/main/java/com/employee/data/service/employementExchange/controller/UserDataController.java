package com.employee.data.service.employementExchange.controller;

import com.employee.data.service.employementExchange.dto.UserDTO;
import com.employee.data.service.employementExchange.services.UserDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user-Data")
public class UserDataController {

    private UserDataService userDataService;

    @PostMapping("/adding-User")
    public ResponseEntity<UserDTO> addingNewUser(@RequestBody UserDTO UserDTO){
        UserDTO userObject =     userDataService.createUser(UserDTO);
        return new ResponseEntity<>(userObject, HttpStatus.CREATED);
    }
    @PutMapping("/updating-User")
    public ResponseEntity<UserDTO> updateExistingUser(@RequestParam Long id , @RequestBody UserDTO user){
        UserDTO result = userDataService.updateUser(id,user);
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<List<UserDTO>> getAllExistingUsers(){
        List<UserDTO> result= userDataService.findAllUser();
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable("id") Long userId){
        userDataService.deleteUserById(userId);
        System.out.println("Deleted the User from Portal !!");
        return ResponseEntity.ok("Deleted the User from Portal !!"+userId);

    }
}
