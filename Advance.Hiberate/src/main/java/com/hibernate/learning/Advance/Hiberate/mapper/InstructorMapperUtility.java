package com.hibernate.learning.Advance.Hiberate.mapper;

import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;

public class InstructorMapperUtility {
        public  static Instructor convertToInstructor(InstructorDTO instructorDTO){
            return  new Instructor(instructorDTO.getInstructorId(),instructorDTO.getInstructorName(),instructorDTO.getMailID());
        }

        public static InstructorDTO convertToInstructorDTO(Instructor instructor){
            return new InstructorDTO(instructor.getInstructorId(),instructor.getInstructorName(),instructor.getMailID());
        }
}
