package com.deportment.data.service.deportmentExchang.controller;

import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.service.DeportmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController = @Controller +@ResponseBody
@AllArgsConstructor
@RequestMapping("/depormentService")
public class DeportmentController {
    private DeportmentService deportmentService;
//    @Autowired
//    public DeportmentController(DeportmentService deportmentService) {
//        this.deportmentService = deportmentService;
//    }

    @PostMapping("/add-Deportment")
    public ResponseEntity<DeportmentDTO> saveDeportment(@RequestBody DeportmentDTO deportmentDTO){
        System.out.println("Input "+deportmentDTO);
        DeportmentDTO savedDptObject = deportmentService.saveDeportment(deportmentDTO);
        System.out.println("Result of controller "+savedDptObject);
        return ResponseEntity.ok(savedDptObject);
    }
}
