package com.hibernate.learning.Advance.Hiberate.service;

import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;

public interface InstructorService {

    public InstructorDTO saveInstructorService(InstructorDTO instructorDTO);
    public void deleteInstructorService(int instructorId);
    public InstructorDTO getInstructorService(int instructorId);

}