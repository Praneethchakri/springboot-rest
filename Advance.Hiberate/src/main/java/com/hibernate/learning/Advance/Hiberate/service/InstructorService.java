package com.hibernate.learning.Advance.Hiberate.service;

import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDetailsDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;

public interface InstructorService {

    public InstructorDTO saveInstructorService(InstructorDTO instructorDTO);
    public void deleteInstructorService(int instructorId);
    public InstructorDTO getInstructorService(int instructorId);
    public InstructorDetailsDTO getInstructorDetailsService(int instructorId);

    public void deleteInstructorDetailsService(int id);

}
