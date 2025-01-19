package com.hibernate.learning.Advance.Hiberate.service.impl;

import com.hibernate.learning.Advance.Hiberate.dao.InstructorDAO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDetailsDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;
import com.hibernate.learning.Advance.Hiberate.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hibernate.learning.Advance.Hiberate.mapper.InstructorMapperStruct.INSTRUCTOR_MAPPER_STRUCT;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public InstructorDTO saveInstructorService(InstructorDTO instructorDTO) {
        Instructor instructor = INSTRUCTOR_MAPPER_STRUCT.mapTOInstructor(instructorDTO);
       return instructorDAO.saveInsturctor(instructor);
    }

    @Override
    public void deleteInstructorService(int instructorId) {
//        Instructor instructor = instructorDAO.getInstructorById(instructorId);
        instructorDAO.deleteInstructor(instructorId);
    }

    @Override
    public InstructorDTO getInstructorService(int instructorId) {
        Instructor instructor =  instructorDAO.getInstructorById(instructorId);
        return  INSTRUCTOR_MAPPER_STRUCT.instructorToInstructorDTO(instructor);
    }

    @Override
    public InstructorDetailsDTO getInstructorDetailsService(int id) {
        InstructorDetails instructorDetails =  instructorDAO.getInstructorDetailsById(id);
        System.out.println("Instructor Details "+instructorDetails.toString());
        System.out.println("Instructor "+instructorDetails.getInstructor());
        InstructorDTO instructorDTO = INSTRUCTOR_MAPPER_STRUCT.instructorToInstructorDTO(instructorDetails.getInstructor());
        InstructorDetailsDTO instructorDetailsDTO =INSTRUCTOR_MAPPER_STRUCT.instructorDetailToInstructorDetailsDTO(instructorDetails);
        instructorDetailsDTO.setInstructorDTO(instructorDTO);
        System.out.println("InstructorDetailsDTO" +instructorDetailsDTO);
        return instructorDetailsDTO;

    }

    @Override
    public void deleteInstructorDetailsService(int id) {
        instructorDAO.deleteInstructorDetailsByID(id);
    }


}
