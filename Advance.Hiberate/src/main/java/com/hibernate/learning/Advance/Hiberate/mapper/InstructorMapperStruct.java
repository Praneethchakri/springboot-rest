package com.hibernate.learning.Advance.Hiberate.mapper;


import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import org.mapstruct.Mapper;
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

    InstructorDTO mapToInstructorDTO(Instructor instructor);
    Instructor mapTOInstructor(InstructorDTO instructorDTO);

}
