package com.hibernate.learning.Advance.Hiberate.mapper;

import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDetailsDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;

public class InstructorMapperUtility {
        public  static Instructor convertToInstructor(InstructorDTO instructorDTO){
            return  new Instructor(instructorDTO.getInstructorId(),instructorDTO.getInstructorName(),instructorDTO.getMailID());
        }

        public static InstructorDTO convertToInstructorDTO(Instructor instructor){
            return new InstructorDTO(instructor.getInstructorId(),instructor.getInstructorName(),instructor.getMailID(),convertToInstructoDetailsDTO(instructor.getInstructorDetail()));
        }

    public static InstructorDetailsDTO convertToInstructoDetailsDTO(InstructorDetails instructorDetails){
        return new InstructorDetailsDTO(instructorDetails.getId(),instructorDetails.getYoutubeChannelDetails(),instructorDetails.getRevenue(),convertToInstructorDTO(instructorDetails.getInstructor()));
    }
}
