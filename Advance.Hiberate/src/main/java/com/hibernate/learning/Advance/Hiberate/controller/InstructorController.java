package com.hibernate.learning.Advance.Hiberate.controller;

import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;
import com.hibernate.learning.Advance.Hiberate.service.InstructorService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> instructorAdd(@RequestBody InstructorDTO instructorDTO){
        try {
            InstructorDTO instructorDTOResponse= instructorService.saveInstructorService(instructorDTO);
            return ResponseEntity.ok(instructorDTOResponse);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error While Saving :: "+e.getMessage());
        }
    }

    @GetMapping("/getInstructor/{instructorId}")
    public ResponseEntity<?> instructorGetById(@PathVariable(name ="instructorId") int instructorId){
        try {
           InstructorDTO instructorDTO =  instructorService.getInstructorService(instructorId);
            return ResponseEntity.ok(instructorDTO);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error While Saving :: "+e.getMessage());
        }
    }

    @DeleteMapping("/deleteInstructor/{instructorId}")
    public ResponseEntity<?> instructorDelete(@PathVariable(name ="instructorId") int instructorId){
        try {
            instructorService.deleteInstructorService(instructorId);
            return ResponseEntity.ok(instructorId);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error While Deleting :: "+e.getMessage());
        }
    }

    @GetMapping("/getInstructorDetails/{id}")
    public ResponseEntity<?> instructorDetailsGetById(@PathVariable(name ="id") int id){
        try {
            InstructorDetails instructorDetails =  instructorService.getInstructorDetailsService(id);
            return ResponseEntity.ok(instructorDetails);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error While Saving :: "+e.getMessage());
        }
    }
}
