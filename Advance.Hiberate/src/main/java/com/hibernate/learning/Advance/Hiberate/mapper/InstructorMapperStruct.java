package com.hibernate.learning.Advance.Hiberate.mapper;


import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDetailsDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import com.hibernate.learning.Advance.Hiberate.entity.InstructorDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstructorMapperStruct {
    /*
    IF the Model classes naming conventions are different in each class we can use the explict mapper on each method as below
    @Mapping(source = "email",target = "emailId")
    Here in the above example the User class has the email field , but while mapping the target class UserDTO has differetn name ,to mapp this we use here the
    @Mapping and map the fields.
     */

    InstructorMapperStruct INSTRUCTOR_MAPPER_STRUCT  = Mappers.getMapper(InstructorMapperStruct.class);
//    @Mapping(source = "instructorDetail", target = "instructorDetailDTO")
//    InstructorDTO mapToInstructorDTO(Instructor instructor);
    @Mapping(source = "instructorDetailDTO", target = "instructorDetail")
    Instructor mapTOInstructor(InstructorDTO instructorDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "youtubeChannelDetails", target = "youtubeChannelDetails")
    @Mapping(source = "revenue", target = "revenue")
//    @Mapping(source = "instructor", target = "instructorDTO")
    InstructorDetailsDTO instructorDetailToInstructorDetailsDTO(InstructorDetails instructorDetails);

    @Mapping(source = "instructorId", target = "instructorId")
    @Mapping(source = "instructorName", target = "instructorName")
    @Mapping(source = "mailID", target = "mailID")
//    @Mapping(source = "instructorDetail", target = "instructorDetailDTO")
    InstructorDTO instructorToInstructorDTO(Instructor instructor);



}
