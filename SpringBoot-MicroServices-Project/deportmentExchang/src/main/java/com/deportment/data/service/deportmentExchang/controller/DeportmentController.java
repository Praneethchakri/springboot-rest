package com.deportment.data.service.deportmentExchang.controller;

import com.deportment.data.service.deportmentExchang.dto.APIresponseDTO;
import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.service.DeportmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{deportment-code}")
    public ResponseEntity<DeportmentDTO> getDeportmentById(@PathVariable(name="deportment-code") String deportmentCode){
        DeportmentDTO resultDeportment = deportmentService.findDeportmentByDeportmentCode(deportmentCode);
        return new ResponseEntity<>(resultDeportment,HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<DeportmentDTO> getDeportmentByName(@RequestParam(name = "deportmentName") String name){
        DeportmentDTO result = deportmentService.findDeportmentByName(name);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/empListByDptCode/{deportment-code}")
    public ResponseEntity<APIresponseDTO> getEmplooyesAndDeportmentByDeptID(@PathVariable(name="deportment-code") String deptCode){
       APIresponseDTO apIresponseDTO = deportmentService.findEmployessByDeportmentCode(deptCode);
       return new ResponseEntity<>(apIresponseDTO,HttpStatus.OK);
    }

}
