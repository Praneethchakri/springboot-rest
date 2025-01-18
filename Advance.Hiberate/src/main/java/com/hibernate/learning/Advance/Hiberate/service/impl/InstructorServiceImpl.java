package com.hibernate.learning.Advance.Hiberate.service.impl;

import com.hibernate.learning.Advance.Hiberate.dao.InstructorDAO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
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
        return  INSTRUCTOR_MAPPER_STRUCT.mapToInstructorDTO(instructor);
    }


}
