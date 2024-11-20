package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.entity.Deportment;
import com.deportment.data.service.deportmentExchang.repository.DeportmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.deportment.data.service.deportmentExchang.mapper.DeportmentMapStruct.DEPORTMENT_MAP_STRUCT;
@Service
@AllArgsConstructor
public class DeportmentServiceImpl implements  DeportmentService{

    private DeportmentRepository deportmentRepository;

    @Override
    public DeportmentDTO saveDeportment(DeportmentDTO deportmentDTO) {
        //Conveters come into Place  from DeportmentDTO to Deportment
        Deportment deportment = DEPORTMENT_MAP_STRUCT.maptTODeportment(deportmentDTO);
        System.out.println("DTO TO Deportment With MapStruct "+deportment);
        Deportment savedDeportment =  deportmentRepository.save(deportment);
        System.out.println("Database Save Deportment "+savedDeportment);
        System.out.println("Response DTO "+DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(savedDeportment));
        return DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(savedDeportment);
    }
}
