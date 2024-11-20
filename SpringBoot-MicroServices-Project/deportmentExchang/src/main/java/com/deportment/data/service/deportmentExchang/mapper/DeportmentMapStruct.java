package com.deportment.data.service.deportmentExchang.mapper;

import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.entity.Deportment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeportmentMapStruct {


    /*
    If the Model classes nameing conventions are different in each class we can use the explict mapper on each method as below
    @Mapping(source = "email",target = "emailId")
    Here in the above example the User class has the email field , but while mapping the target class UserDTO has differetn name ,to mapp this we use here the
    @Mapping and map the fields.
     */

    DeportmentMapStruct DEPORTMENT_MAP_STRUCT  = Mappers.getMapper(DeportmentMapStruct.class);

        DeportmentDTO mapToDeportmentDTO(Deportment deportment);
         Deportment maptTODeportment(DeportmentDTO deportmentDTO);

}
