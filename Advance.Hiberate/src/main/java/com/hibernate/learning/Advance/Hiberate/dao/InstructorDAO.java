package com.hibernate.learning.Advance.Hiberate.dao;


import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;
import org.springframework.stereotype.Repository;


public interface InstructorDAO {
    public InstructorDTO saveInsturctor(Instructor instructor);
    public void deleteInstructor(int instructorId);

    public Instructor getInstructorById(int instructorId);

    //BiDirectional
    public InstructorDetails getInstructorDetailsById(int id);

    public void deleteInstructorDetailsByID(int id);
}
