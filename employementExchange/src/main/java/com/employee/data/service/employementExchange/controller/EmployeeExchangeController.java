package com.employee.data.service.employementExchange.controller;


import com.employee.data.service.employementExchange.entityModel.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeExchangeController {

    @GetMapping("/hello-world")// we use this Get Mapping,for the incoming GET Rqeust from Client
    public String helloWorld(){
        return  "Hello Spring Boot World!!";
    }
    // Spring Boot REST API with Path Param(@PathVariable)
//    Using @PathVariable service
    @GetMapping("/employee/{empID}")
    public ResponseEntity<Employee> getEmployeeByIdPathVariable(@PathVariable("empID") Long id){
        Employee e = new Employee(id,"Praneeth","Diguvapalem","Germany");
        return ResponseEntity.ok().header("Customer-TestHeader","SampleTestCase")
                .body(e);
    }

    @GetMapping("/employeeList")
    public  ResponseEntity<List<Employee>> getEmployeesList(){
        List<Employee> employeeList = new ArrayList<>();
      employeeList.add(new Employee(1234L,"Praneeth","Diguvapalem","Germany"));
        employeeList.add(new Employee(12345L,"Praneeth","Diguvapalem","Germany"));
        employeeList.add(new Employee(123456L,"Praneeth","Diguvapalem","Germany"));
        employeeList.add(new Employee(1234567L,"Praneeth","Diguvapalem","Germany"));
    return ResponseEntity.ok(employeeList);

    }

    @GetMapping("/employee/{empId}/{first-Name}/{last-Name}")
    public Employee getEmployeeWithPathVariables(@PathVariable("empId") Long id,
                                                 @PathVariable("first-Name") String firstName,
                                                 @PathVariable("last-Name") String lastName){
        return new Employee(id,firstName,lastName,"Germany");
    }
    // Spring Boot REST API with Request Param(@ReqeustParam)
    @GetMapping("/employee/query")
    public Employee getEmployeeWithRequestParam(@RequestParam Long id){
       return new Employee(id,"Diguvapalem","Praneeth","Germany");
    }
    @GetMapping("/employee/multiple-QueryParam")
    public Employee getEmployeeWithMultipleRequestParam(@RequestParam Long id,@RequestParam String lastName){
        return new Employee(id,lastName,"Praneeth","Germany");
    }
    @PostMapping("/add-NewEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee e){
        return e;
    }

    @PutMapping("/update-employee/{id}/update")
    public Employee updateEmployee(@RequestBody Employee e,@PathVariable("id") Long id){
        System.out.println("Employee Data FirstName :: "+e.getFirstName());
        System.out.println("Employee Data LastName ::"+e.getLastName());
        return e;
    }

}


