package com.employee.data.service.employementExchange.controller;

import com.employee.data.service.employementExchange.dto.APIResponseDTO;
import com.employee.data.service.employementExchange.dto.EmployeeDTO;
import com.employee.data.service.employementExchange.exception.ResponseModel;
import com.employee.data.service.employementExchange.services.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/employee-Data")
public class EmployeeDataController {
    private EmployeeDataService employeeDataService;

    @PostMapping("/adding-Employee")
    public ResponseEntity<?> addingNewEmployee(@RequestBody EmployeeDTO UserDTO){
        EmployeeDTO userObject =     employeeDataService.createUser(UserDTO);
        ResponseModel responseModel = new ResponseModel("EmployeeDetails Added "+userObject.getId(),HttpStatus.CREATED.toString());
        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }
    @PutMapping("/updating-Employee")
    public ResponseEntity<?> updateExistingEmployee(@RequestParam Long id , @RequestBody EmployeeDTO user){
        EmployeeDTO result = employeeDataService.updateUser(id,user);
        ResponseModel responseModel = new ResponseModel("EmployeeDetails Updated!! "+id,HttpStatus.CREATED.toString());
        return new ResponseEntity<>(responseModel,HttpStatus.ACCEPTED);
    }
    @GetMapping("/getEmployeeByID")
    public ResponseEntity<?> getEmployeeById(@RequestParam Long id) {
        Optional<APIResponseDTO> employeeDTO;
            employeeDTO = employeeDataService.findEmployeeById(id);
        return new ResponseEntity<>(employeeDTO.get(), HttpStatus.OK);
    }

    @GetMapping("/AllEmployee")
    public ResponseEntity<List<EmployeeDTO>> getAllExistingEmployee(){
        List<EmployeeDTO> result= employeeDataService.findAllUser();
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable("id") Long employeeId){
        employeeDataService.deleteUserById(employeeId);
        System.out.println("Deleted the Employee from Portal !!");
        return ResponseEntity.ok("Deleted the Employee from Portal !!"+employeeId);

    }
}
